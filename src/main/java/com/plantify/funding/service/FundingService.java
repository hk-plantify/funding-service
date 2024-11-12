package com.plantify.funding.service;

import com.plantify.funding.domain.dto.request.FundingRequest;
import com.plantify.funding.domain.dto.response.FundingResponse;

import java.util.List;

public interface FundingService {

    List<FundingResponse> getAllFundings();
    FundingResponse getFunding(Long fundingId);
    FundingResponse addFunding(String authorizationHeader, FundingRequest request);
    FundingResponse updateFunding(String authorizationHeader, Long fundingId, FundingRequest request);
    void deleteFunding(String authorizationHeader, Long fundingId);
}
