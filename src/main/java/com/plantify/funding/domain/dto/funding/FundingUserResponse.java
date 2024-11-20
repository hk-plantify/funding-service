package com.plantify.funding.domain.dto.funding;

import ch.qos.logback.core.status.Status;
import com.plantify.funding.domain.entity.Category;
import com.plantify.funding.domain.entity.Funding;

public record FundingUserResponse(
        Long fundingId,
        String title,
        String content,
        String image,
        Long curAmount,
        Long targetAmount,
        Double percent,
        Status status,
        Category category
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
                funding.getCategory()
        );
    }
}
