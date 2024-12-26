package com.plantify.funding.domain.dto.myFunding;

import com.plantify.funding.domain.entity.MyFunding;

import java.time.LocalDateTime;

public record MyFundingAdminResponse(
        Long myFundingId,
        Long userId,
        Long fundingId,
        Long price,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static MyFundingAdminResponse from(MyFunding myFunding) {
        return new MyFundingAdminResponse(
                myFunding.getMyFundingId(),
                myFunding.getUserId(),
                myFunding.getFunding().getFundingId(),
                myFunding.getPrice(),
                myFunding.getCreatedAt(),
                myFunding.getUpdatedAt()
        );
    }
}
