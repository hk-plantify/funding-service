package com.plantify.funding.service.funding;

import com.plantify.funding.domain.dto.funding.FundingUserResponse;
import com.plantify.funding.domain.entity.Category;
import com.plantify.funding.domain.entity.Funding;
import com.plantify.funding.global.exception.ApplicationException;
import com.plantify.funding.global.exception.errorcode.FundingErrorCode;
import com.plantify.funding.repository.FundingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FundingUserServiceImpl implements FundingUserService {

    private final FundingRepository fundingRepository;

    @Override
    public Page<FundingUserResponse> getAllFunding(Pageable pageable) {
        return fundingRepository.findAll(pageable)
                .map(FundingUserResponse::from);
    }

    @Override
    public FundingUserResponse getFundingById(Long fundingId) {
        Funding funding = fundingRepository.findById(fundingId)
                .orElseThrow(() -> new ApplicationException(FundingErrorCode.FUNDING_NOT_FOUND));
        return FundingUserResponse.from(funding);
    }

    @Override
    public Page<FundingUserResponse> getFundingByCategory(Category category, Pageable pageable) {
        return fundingRepository.findByCategory(category, pageable)
                .map(FundingUserResponse::from);
    }
}
