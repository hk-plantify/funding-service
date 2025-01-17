package com.plantify.funding.domain.dto.funding;

import com.plantify.funding.domain.entity.Category;
import com.plantify.funding.domain.entity.Funding;
import com.plantify.funding.domain.entity.Status;

import java.time.LocalDateTime;
import java.util.Date;

public record FundingUserResponse(
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
        LocalDateTime donationEndDate,
        Long organizationId,
        String organizationName
) {
    public static FundingUserResponse from(Funding funding) {
        return new FundingUserResponse(
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
                funding.getDonationEndDate(),
                funding.getOrganization().getOrganizationId(),
                funding.getOrganization().getName()
        );
    }
}
