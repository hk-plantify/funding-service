package com.plantify.funding.domain.dto.funding;

import com.plantify.funding.domain.entity.Category;
import com.plantify.funding.domain.entity.Funding;
import com.plantify.funding.domain.entity.Status;

import java.time.LocalDateTime;

public record FundingAdminRequest(
        String title,
        String content,
        String image,
        Long curAmount,
        Long targetAmount,
        Double percent,
        Status status,
        Category category,
        LocalDateTime fundingStartDate,
        LocalDateTime fundingEndDate,
        LocalDateTime donationStartDate,
        LocalDateTime donationEndDate
) {

    public Funding toEntity() {
        return Funding.builder()
                .title(title)
                .content(content)
                .image(image)
                .targetAmount(targetAmount != null ? targetAmount : 0)
                .curAmount(curAmount != null ? curAmount : 0L)
                .percent(percent != null ? percent: 0.0)
                .status(status)
                .category(category)
                .fundingStartDate(fundingStartDate)
                .fundingEndDate(fundingEndDate)
                .donationStartDate(donationStartDate)
                .donationEndDate(donationEndDate)
                .build();
    }

    public Funding updatedFunding(Funding funding){
        return funding.toBuilder()
                .title(this.title())
                .content(this.content())
                .image(this.image())
                .targetAmount(this.targetAmount())
                .fundingStartDate(fundingStartDate)
                .fundingEndDate(fundingEndDate)
                .donationStartDate(donationStartDate)
                .donationEndDate(donationEndDate)
                .build();
    }
}
