package com.plantify.funding.service.myFunding;

import com.plantify.funding.client.PayServiceClient;
import com.plantify.funding.domain.dto.myFunding.*;
import com.plantify.funding.domain.entity.Funding;
import com.plantify.funding.domain.entity.MyFunding;
import com.plantify.funding.global.exception.ApplicationException;
import com.plantify.funding.global.exception.errorcode.FundingErrorCode;
import com.plantify.funding.global.exception.errorcode.MyFundingErrorCode;
import com.plantify.funding.repository.FundingRepository;
import com.plantify.funding.repository.MyFundingRepository;
import com.plantify.funding.global.util.UserInfoProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class MyFundingUserServiceImpl implements MyFundingUserService {

    private final MyFundingRepository myFundingRepository;
    private final FundingRepository fundingRepository;
    private final UserInfoProvider userInfoProvider;
    private final PayServiceClient payServiceClient;

    @Override
    public Page<MyFundingDetailResponse> getMyFunding(Pageable pageable) {
        Long userId = userInfoProvider.getUserInfo().userId();

        return myFundingRepository.findAllByUserId(userId, pageable)
                .map(MyFundingDetailResponse::from);
    }

    @Override
    public MyFundingDetailResponse getMyFundingDetails(Long myFundingId) {
        Long userId = userInfoProvider.getUserInfo().userId();

        MyFunding myFunding = myFundingRepository.findByMyFundingIdAndUserId(myFundingId, userId)
                .orElseThrow(() -> new ApplicationException(MyFundingErrorCode.FUNDING_NOT_FOUND));

        return MyFundingDetailResponse.from(myFunding);
    }

    @Override
    @Transactional
    public String participate(MyFundingUserRequest request) {
        Long userId = userInfoProvider.getUserInfo().userId();
        Funding funding = fundingRepository.findById(request.fundingId())
                .orElseThrow(() -> new ApplicationException(FundingErrorCode.FUNDING_NOT_FOUND));

        PendingTransactionRequest pendingTransactionRequest = new PendingTransactionRequest(
                userId,
                1L,
                funding.getTitle(),
                request.price(),
                request.redirectUri()
        );
        String token = payServiceClient.initiatePayment(pendingTransactionRequest);

        log.info("token: {}", token);
        return token;
    }

    @Override
    public MyFundingUserResponse callbackParticipate(String orderId) {
        ExternalSettlementResponse response = payServiceClient.getSettlementByOrderId(orderId).getBody();

        Long userId = userInfoProvider.getUserInfo().userId();
        Funding funding = fundingRepository.findByTitle(response.orderName())
                .orElseThrow(() -> new ApplicationException(FundingErrorCode.FUNDING_NOT_FOUND));

        MyFundingUserRequest request = new MyFundingUserRequest(funding.getFundingId(), response.amount(), null);
        MyFunding myFunding = request.toEntity(userId, funding);
        MyFunding savedFunding = myFundingRepository.save(myFunding);

        funding.increase(response.amount());

        return MyFundingUserResponse.from(savedFunding);
    }

    @Override
    @Transactional
    public MyFundingUserResponse cancel(Long myFundingId, MyFundingUserRequest request) {
        Long userId = userInfoProvider.getUserInfo().userId();
        Funding funding = fundingRepository.findById(request.fundingId())
                .orElseThrow(() -> new ApplicationException(FundingErrorCode.FUNDING_NOT_FOUND));

        MyFunding myFunding = myFundingRepository.findByMyFundingIdAndUserId(myFundingId, userId)
                .orElseThrow(() -> new ApplicationException(MyFundingErrorCode.FUNDING_NOT_FOUND))
                .cancellation(request.price());
        MyFunding savedFunding = myFundingRepository.save(myFunding);
        funding.decrease(request.price());

        return MyFundingUserResponse.from(savedFunding);
    }
}
