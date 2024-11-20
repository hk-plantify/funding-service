package com.plantify.funding.service.myFunding;

import com.plantify.funding.domain.dto.myFunding.MyFundingUserRequest;
import com.plantify.funding.domain.dto.myFunding.MyFundingUserResponse;
import com.plantify.funding.domain.entity.MyFunding;
import com.plantify.funding.global.exception.ApplicationException;
import com.plantify.funding.global.exception.errorcode.MyFundingErrorCode;
import com.plantify.funding.repository.MyFundingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MyFundingUserServiceImpl implements MyFundingUserService {

    private final MyFundingRepository myFundingRepository;

    @Override
    public Page<MyFundingUserResponse> getMyFunding(Pageable pageable) {
        return myFundingRepository.findAll(pageable)
                .map(MyFundingUserResponse::from);
    }

    @Override
    public MyFundingUserResponse getMyFundingDetails(Long myFundingId) {
        MyFunding myFunding = myFundingRepository.findById(myFundingId)
                .orElseThrow(() -> new ApplicationException(MyFundingErrorCode.FUNDING_NOT_FOUND));
        return MyFundingUserResponse.from(myFunding);
    }

    @Override
    public MyFundingUserResponse createMyFunding(MyFundingUserRequest request) {
        MyFunding myFunding = request.toEntity(request.fundingId());
        MyFunding savedFunding = myFundingRepository.save(myFunding);
        return MyFundingUserResponse.from(savedFunding);
    }

    @Override
    public MyFundingUserResponse updateMyFunding(Long myFundingId, MyFundingUserRequest request) {
        MyFunding myFunding = myFundingRepository.findById(myFundingId)
                .orElseThrow(() -> new ApplicationException(MyFundingErrorCode.FUNDING_NOT_FOUND));

        MyFunding updatedFunding = myFunding.toBuilder()
                .price(request.price())
                .build();

        MyFunding savedFunding = myFundingRepository.save(updatedFunding);
        return MyFundingUserResponse.from(savedFunding);
    }
}
