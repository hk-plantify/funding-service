package com.plantify.funding.service;

import com.plantify.funding.domain.dto.request.FundingRequest;
import com.plantify.funding.domain.dto.response.FundingResponse;
import com.plantify.funding.domain.entity.Funding;
import com.plantify.funding.repository.FundingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FundingServiceImpl implements FundingService {

    private final FundingRepository fundingRepository;

    @Override
    public List<FundingResponse> getAllFundings() {
        return List.of();
    }

    @Override
    public FundingResponse getFunding(Long fundingId) {
        return null;
    }

    @Override
    public FundingResponse addFunding(FundingRequest request) {
        return null;
    }

    @Override
    public FundingResponse updateFunding(Long fundingId, FundingRequest request) {
        return null;
    }

    @Override
    public void deleteFunding(Long fundingId) {

    }
}
