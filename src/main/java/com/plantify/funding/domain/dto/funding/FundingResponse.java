package com.plantify.funding.domain.dto.funding;

import com.plantify.funding.domain.entity.Category;
import com.plantify.funding.domain.entity.Funding;
import com.plantify.funding.domain.entity.Status;

import java.time.LocalDateTime;

public record FundingResponse(
        Long fundingId,
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
    public static FundingResponse from(Funding funding) {
        return new FundingResponse(
                funding.getFundingId(),
                funding.getTitle(),
                funding.getContent(),
                funding.getImage(),
                funding.getCurAmount(),
                funding.getTargetAmount(),
                funding.getPercent(),
                funding.getStatus(),
                funding.getCategory(),
                funding.getFundingStartDate(),
                funding.getFundingEndDate(),
                funding.getDonationStartDate(),
                funding.getDonationEndDate()
        );
    }
}