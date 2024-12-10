package com.plantify.funding.service.myFunding;

import com.plantify.funding.client.PayServiceClient;
import com.plantify.funding.domain.dto.myFunding.TransactionRequest;
import com.plantify.funding.domain.dto.myFunding.MyFundingDetailResponse;
import com.plantify.funding.domain.dto.myFunding.MyFundingUserRequest;
import com.plantify.funding.domain.dto.myFunding.MyFundingUserResponse;
import com.plantify.funding.domain.entity.Funding;
import com.plantify.funding.domain.entity.MyFunding;
import com.plantify.funding.global.exception.ApplicationException;
import com.plantify.funding.global.exception.errorcode.FundingErrorCode;
import com.plantify.funding.global.exception.errorcode.MyFundingErrorCode;
import com.plantify.funding.repository.FundingRepository;
import com.plantify.funding.repository.MyFundingRepository;
import com.plantify.funding.global.util.UserInfoProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    public MyFundingUserResponse participate(MyFundingUserRequest request) {
        Long userId = userInfoProvider.getUserInfo().userId();
        Funding funding = fundingRepository.findById(request.fundingId())
                .orElseThrow(() -> new ApplicationException(FundingErrorCode.FUNDING_NOT_FOUND));

        TransactionRequest transactionRequest = new TransactionRequest(
                userId,
                1L,
                funding.getTitle(),
                request.price(),
                "PAYMENT",
                null
        );

        payServiceClient.payment(transactionRequest);

        MyFunding myFunding = request.toEntity(userId, funding);
        MyFunding savedFunding = myFundingRepository.save(myFunding);
        funding.increase(request.price());

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
