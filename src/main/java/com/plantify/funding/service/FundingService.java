package com.plantify.funding.service;

import com.plantify.funding.domain.dto.request.FundingRequest;
import com.plantify.funding.domain.dto.response.FundingResponse;

import java.util.List;

public interface FundingService {

    List<FundingResponse> getAllFundings();
    FundingResponse getFunding(Long fundingId);
    FundingResponse addFunding(FundingRequest request);
    FundingResponse updateFunding(Long fundingId, FundingRequest request);
    void deleteFunding(Long fundingId);
}
