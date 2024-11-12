package com.plantify.funding.service;

import com.plantify.funding.domain.dto.request.MyFundingRequest;
import com.plantify.funding.domain.dto.response.MyFundingResponse;

import java.util.List;

public interface MyFundingService {

    List<MyFundingResponse> getAllMyFundings();
    MyFundingResponse getMyFunding(MyFundingRequest request);
    MyFundingResponse addMyFunding(MyFundingRequest request);
    void deleteMyFunding(MyFundingRequest request);
}
