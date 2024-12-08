package com.plantify.funding.service.funding;

import com.plantify.funding.domain.dto.funding.FundingAdminRequest;
import com.plantify.funding.domain.dto.funding.FundingAdminResponse;
import com.plantify.funding.domain.entity.Status;

public interface FundingAdminService {

    FundingAdminResponse createFunding(FundingAdminRequest request);
    FundingAdminResponse updateFunding(Long fundingId, FundingAdminRequest request);
    void deleteFunding(Long fundingId);
    FundingAdminResponse updateFundingStatus(Long fundingId, Status status);
}
