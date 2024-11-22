package com.plantify.funding.service.myFunding;

import com.plantify.funding.domain.dto.myFunding.MyFundingAdminResponse;

import java.util.List;

public interface MyFundingAdminService {

    List<MyFundingAdminResponse> getAllFunding();
    MyFundingAdminResponse getMyFundingDetails(String myFundingId);
    List<MyFundingAdminResponse> getUserFunding(Long userId);
}
