package com.plantify.funding.domain.dto.request;

import com.plantify.funding.domain.entity.Category;
import com.plantify.funding.domain.entity.Funding;

import java.time.LocalDateTime;

public record FundingRequest(
        Long organizationId,
        String title,
        String content,
        String image,
        Long targetAmount,
        Category category,
        LocalDateTime fundingStartDate,
        LocalDateTime fundingEndDate,
        LocalDateTime donationStartDate,
        LocalDateTime donationEndDate
) {

    public Funding toEntity() {
        return Funding.builder()
                .organizationId(organizationId)
                .title(title)
                .content(content)
                .image(image)
                .targetAmount(targetAmount)
                .category(category)
                .fundingStartDate(fundingStartDate)
                .fundingEndDate(fundingEndDate)
                .donationStartDate(donationStartDate)
                .donationEndDate(donationEndDate)
                .build();
    }
}
