package com.plantify.funding.service.myFunding;

import com.plantify.funding.domain.dto.myFunding.MyFundingUserRequest;
import com.plantify.funding.domain.dto.myFunding.MyFundingUserResponse;
import com.plantify.funding.domain.entity.MyFunding;
import com.plantify.funding.domain.entity.Status;
import com.plantify.funding.global.exception.ApplicationException;
import com.plantify.funding.global.exception.errorcode.MyFundingErrorCode;
import com.plantify.funding.repository.MyFundingRepository;
import com.plantify.funding.service.funding.InternalService;
import com.plantify.funding.util.UserInfoProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MyFundingUserServiceImpl implements MyFundingUserService {

    private final MyFundingRepository myFundingRepository;
    private final UserInfoProvider userInfoProvider;
    private final InternalService internalService;

    @Override
    public Page<MyFundingUserResponse> getMyFunding(Pageable pageable) {
        Long userId = userInfoProvider.getUserInfo().userId();
        return myFundingRepository.findAllByUserId(pageable, userId)
                .map(MyFundingUserResponse::from);
    }

    @Override
    public MyFundingUserResponse getMyFundingDetails(String myFundingId) {
        Long userId = userInfoProvider.getUserInfo().userId();

        MyFunding myFunding = myFundingRepository.findByMyFundingIdAndUserId(myFundingId, userId)
                .orElseThrow(() -> new ApplicationException(MyFundingErrorCode.FUNDING_NOT_FOUND));

        return MyFundingUserResponse.from(myFunding);
    }

    @Override
    @Transactional
    public MyFundingUserResponse createMyFunding(MyFundingUserRequest request) {
        Long userId = 1L;
//        Long userId = userInfoProvider.getUserInfo().userId();
        Optional<MyFunding> existingFunding = myFundingRepository.findByUserIdAndFundingId(userId, request.fundingId());

        MyFunding myFunding;
        if (existingFunding.isPresent()) {
            MyFunding existing = existingFunding.get();
            myFunding = existing.toBuilder()
                    .price(existing.getPrice() + request.price())
                    .build();
        } else {
            myFunding = request.toEntity(userId);
        }
        MyFunding savedFunding = myFundingRepository.save(myFunding);
        internalService.updateFundingAmount(request.fundingId(), request.price());

        return MyFundingUserResponse.from(savedFunding);
    }

    @Override
    @Transactional
    public MyFundingUserResponse updateMyFunding(String myFundingId, MyFundingUserRequest request) {
        Long userId = userInfoProvider.getUserInfo().userId();
        MyFunding myFunding = myFundingRepository.findByMyFundingIdAndUserId(myFundingId, userId)
                .orElseThrow(() -> new ApplicationException(MyFundingErrorCode.FUNDING_NOT_FOUND));

        MyFunding updatedFunding = myFunding.toBuilder()
                .price(request.price())
                .build();
        MyFunding savedFunding = myFundingRepository.save(updatedFunding);
        return MyFundingUserResponse.from(savedFunding);
    }
}
