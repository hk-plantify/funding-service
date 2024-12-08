package com.plantify.funding.service.funding;

import com.plantify.funding.domain.dto.funding.FundingUserResponse;
import com.plantify.funding.domain.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FundingUserService {

    Page<FundingUserResponse> getAllFunding(Pageable pageable);
    FundingUserResponse getFundingById(Long fundingId);
    Page<FundingUserResponse> getFundingByCategory(Category category, Pageable pageable);
}
