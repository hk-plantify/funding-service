package com.plantify.funding.service.myFunding;

import com.plantify.funding.domain.dto.myFunding.MyFundingUserRequest;
import com.plantify.funding.domain.dto.myFunding.MyFundingUserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MyFundingUserService {

    Page<MyFundingUserResponse> getMyFunding(Pageable pageable);
    MyFundingUserResponse getMyFundingDetails(String myFundingId);
    MyFundingUserResponse createMyFunding(MyFundingUserRequest request);
    MyFundingUserResponse updateMyFunding(String myFundingId, MyFundingUserRequest request);
}