package com.plantify.funding.service;

import com.plantify.funding.domain.dto.request.FundingRequest;
import com.plantify.funding.domain.dto.response.FundingResponse;
import com.plantify.funding.domain.entity.Funding;
import com.plantify.funding.global.exception.ApplicationException;
import com.plantify.funding.global.exception.errorcode.FundingErrorCode;
import com.plantify.funding.repository.FundingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FundingServiceImpl implements FundingService {

    private final FundingRepository fundingRepository;
    private final AuthenticationService authenticationService;

    @Override
    public List<FundingResponse> getAllFundings() {
        return fundingRepository.findAll()
                .stream()
                .map(FundingResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public FundingResponse getFunding(Long fundingId) {
        Funding funding = fundingRepository.findById(fundingId)
                .orElseThrow(() -> new ApplicationException(FundingErrorCode.FUNDING_NOT_FOUND));
        return FundingResponse.from(funding);
    }

    @Override
    public FundingResponse addFunding(String authorizationHeader, FundingRequest request) {
        authenticationService.validateRole(authorizationHeader);
        Funding funding = request.toEntity();
        Funding savedFunding = fundingRepository.save(funding);
        return FundingResponse.from(savedFunding);
    }

    @Override
    public FundingResponse updateFunding(String authorizationHeader, Long fundingId, FundingRequest request) {
        authenticationService.validateRole(authorizationHeader);
        Funding funding = fundingRepository.findById(fundingId)
                .orElseThrow(() -> new ApplicationException(FundingErrorCode.FUNDING_NOT_FOUND));

        Funding updatedFunding = Funding.builder()
                .fundingId(funding.getFundingId())
                .organizationId(request.organizationId())
                .title(request.title())
                .content(request.content())
                .image(request.image())
                .targetAmount(request.targetAmount())
                .category(request.category())
                .fundingStartDate(request.fundingStartDate())
                .fundingEndDate(request.fundingEndDate())
                .donationStartDate(request.donationStartDate())
                .donationEndDate(request.donationEndDate())
                .curAmount(funding.getCurAmount())
                .percent(funding.getPercent())
                .status(funding.getStatus())
                .build();

        Funding savedFunding = fundingRepository.save(updatedFunding);
        return FundingResponse.from(savedFunding);
    }

    @Override
    public void deleteFunding(String authorizationHeader, Long fundingId) {
        authenticationService.validateRole(authorizationHeader);
        Funding funding = fundingRepository.findById(fundingId)
                .orElseThrow(() -> new ApplicationException(FundingErrorCode.FUNDING_NOT_FOUND));
        fundingRepository.delete(funding);
    }

}
