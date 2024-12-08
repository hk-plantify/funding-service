package com.plantify.funding.service.myFunding;

import com.plantify.funding.domain.dto.myFunding.MyFundingDetailResponse;
import com.plantify.funding.domain.dto.myFunding.MyFundingUserRequest;
import com.plantify.funding.domain.dto.myFunding.MyFundingUserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MyFundingUserService {

    Page<MyFundingDetailResponse> getMyFunding(Pageable pageable);
    MyFundingDetailResponse getMyFundingDetails(Long myFundingId);
    MyFundingUserResponse participate(MyFundingUserRequest request);
    MyFundingUserResponse cancel(Long myFundingId, MyFundingUserRequest request);
}