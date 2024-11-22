package com.plantify.funding.service.funding;

import com.plantify.funding.domain.dto.funding.FundingAdminRequest;
import com.plantify.funding.domain.dto.funding.FundingAdminResponse;
import com.plantify.funding.domain.entity.Funding;
import com.plantify.funding.domain.entity.Status;
import com.plantify.funding.global.exception.ApplicationException;
import com.plantify.funding.global.exception.errorcode.FundingErrorCode;
import com.plantify.funding.repository.FundingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FundingAdminServiceImpl implements FundingAdminService {

    private final FundingRepository fundingRepository;

    @Override
    public FundingAdminResponse createFunding(FundingAdminRequest request) {
        Funding funding = request.toEntity();
        Funding savedFunding = fundingRepository.save(funding);
        return FundingAdminResponse.from(savedFunding);
    }

    @Override
    public FundingAdminResponse updateFunding(String fundingId, FundingAdminRequest request) {
        Funding funding = fundingRepository.findById(fundingId)
                .orElseThrow(() -> new ApplicationException(FundingErrorCode.FUNDING_NOT_FOUND));

        Funding updatedFunding = request.updatedFunding(funding);

        fundingRepository.save(updatedFunding);
        return FundingAdminResponse.from(updatedFunding);
    }

    @Override
    public void deleteFunding(String fundingId) {
        Funding funding = fundingRepository.findById(fundingId)
                .orElseThrow(() -> new ApplicationException(FundingErrorCode.FUNDING_NOT_FOUND));
        fundingRepository.delete(funding);
    }

    @Override
    public FundingAdminResponse updateFundingStatus(String fundingId, Status status) {
        Funding funding = fundingRepository.findById(fundingId)
                .orElseThrow(() -> new ApplicationException(FundingErrorCode.FUNDING_NOT_FOUND));

        Funding updatedFunding = funding.toBuilder()
                .status(status)
                .build();

        fundingRepository.save(updatedFunding);
        return FundingAdminResponse.from(updatedFunding);
    }
}
