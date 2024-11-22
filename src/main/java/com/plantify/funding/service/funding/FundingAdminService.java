package com.plantify.funding.service.funding;

import com.plantify.funding.domain.dto.funding.FundingAdminRequest;
import com.plantify.funding.domain.dto.funding.FundingAdminResponse;
import com.plantify.funding.domain.entity.Status;

public interface FundingAdminService {

    FundingAdminResponse createFunding(FundingAdminRequest request);
    FundingAdminResponse updateFunding(String fundingId, FundingAdminRequest request);
    void deleteFunding(String fundingId);
    FundingAdminResponse updateFundingStatus(String fundingId, Status status);
}
