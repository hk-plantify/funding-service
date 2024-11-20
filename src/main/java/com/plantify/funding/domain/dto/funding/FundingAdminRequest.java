package com.plantify.funding.domain.dto.funding;

import com.plantify.funding.domain.entity.Category;
import com.plantify.funding.domain.entity.Funding;
import com.plantify.funding.domain.entity.Status;

import java.time.LocalDateTime;

public record FundingAdminRequest(
        String title,
        String content,
        String image,
        Long targetAmount,
        LocalDateTime fundingStartDate,
        LocalDateTime fundingEndDate,
        LocalDateTime donationStartDate,
        LocalDateTime donationEndDate,
        Category category
) {
    public Funding toEntity() {
        return Funding.builder()
                .title(title)
                .content(content)
                .image(image)
                .targetAmount(targetAmount)
                .curAmount(0L)
                .percent(0.0)
                .status(Status.INPROGRESS)
                .category(category)
                .fundingStartDate(fundingStartDate)
                .fundingEndDate(fundingEndDate)
                .donationStartDate(donationStartDate)
                .donationEndDate(donationEndDate)
                .build();
    }
}
