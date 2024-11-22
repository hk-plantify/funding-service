package com.plantify.funding.domain.dto.myFunding;

import com.plantify.funding.domain.entity.MyFunding;
import com.plantify.funding.domain.entity.Status;

import java.time.LocalDateTime;

public record MyFundingUserResponse(
        String myFundingId,
        String fundingId,
        Long price,
        Status status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static MyFundingUserResponse from(MyFunding myFunding) {
        return new MyFundingUserResponse(
                myFunding.getMyFundingId(),
                myFunding.getFundingId(),
                myFunding.getPrice(),
                myFunding.getStatus(),
                myFunding.getCreatedAt(),
                myFunding.getUpdatedAt()
        );
    }
}
