package com.plantify.funding.service;

import com.plantify.funding.domain.dto.request.MyFundingRequest;
import com.plantify.funding.domain.dto.response.FundingResponse;
import com.plantify.funding.domain.dto.response.MyFundingResponse;

import java.util.List;

public interface MyFundingService {

    List<MyFundingResponse> getAllMyFundings(String authorizationHeader);
    FundingResponse getMyFunding(String authorizationHeader, Long fundingId);
    MyFundingResponse addMyFunding(String authorizationHeader, MyFundingRequest request);
    void deleteMyFunding(String authorizationHeader, Long myFundingId);
}
