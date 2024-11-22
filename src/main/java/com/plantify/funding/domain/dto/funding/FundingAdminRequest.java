package com.plantify.funding.domain.dto.funding;

import com.plantify.funding.domain.entity.Category;
import com.plantify.funding.domain.entity.Funding;
import com.plantify.funding.domain.entity.Status;

import java.time.LocalDateTime;
import java.util.Date;

public record FundingAdminRequest(
        String title,
        String content,
        String image,
        Long curAmount,
        Long targetAmount,
        Double percent,
        String status,
        String category,
        String fundingStartDate,
        String fundingEndDate,
        String donationStartDate,
        String donationEndDate
) {
    public Funding toEntity() {
        return Funding.builder()
                .title(title)
                .content(content)
                .image(image)
                .targetAmount(targetAmount != null ? targetAmount : 0)
                .curAmount(curAmount != null ? curAmount : 0L)
                .percent(percent != null ? percent: 0.0)
                .status(toStatus(status))
                .category(toCategory())
                .fundingStartDate(LocalDateTime.parse(fundingStartDate.replaceFirst(" ","T")))
                .fundingEndDate(LocalDateTime.parse(fundingEndDate.replaceFirst(" ","T")))
                .donationStartDate(LocalDateTime.parse(donationStartDate.replaceFirst(" ","T")))
                .donationEndDate(LocalDateTime.parse(donationEndDate.replaceFirst(" ","T")))
                .build();
    }
    public Funding updatedFunding(Funding funding){
        return funding.toBuilder()
                .title(this.title())
                .content(this.content())
                .image(this.image())
                .targetAmount(this.targetAmount())
                .fundingStartDate(LocalDateTime.parse(fundingStartDate.replaceFirst(" ","T")))
                .fundingEndDate(LocalDateTime.parse(fundingEndDate.replaceFirst(" ","T")))
                .donationStartDate(LocalDateTime.parse(donationStartDate.replaceFirst(" ","T")))
                .donationEndDate(LocalDateTime.parse(donationEndDate.replaceFirst(" ","T")))
                .build();
    }

    private Status toStatus(String status) {
        return status == null ? Status.INPROGRESS : Status.valueOf(status.toUpperCase());
    }

    private Category toCategory() {
        return Category.valueOf(category.toUpperCase());
    }
}
