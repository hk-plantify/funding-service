package com.plantify.funding.domain.dto.myFunding;

import com.plantify.funding.domain.entity.MyFunding;

import java.time.LocalDateTime;

public record MyFundingUserResponse(
        Long myFundingId,
        Long fundingId,
        Long price,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static MyFundingUserResponse from(MyFunding myFunding) {
        return new MyFundingUserResponse(
                myFunding.getMyFundingId(),
                myFunding.getFunding().getFundingId(),
                myFunding.getPrice(),
                myFunding.getCreatedAt(),
                myFunding.getUpdatedAt()
        );
    }
}
