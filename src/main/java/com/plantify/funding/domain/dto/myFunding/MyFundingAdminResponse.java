package com.plantify.funding.domain.dto.myFunding;

import com.plantify.funding.domain.entity.MyFunding;
import com.plantify.funding.domain.entity.Status;

import java.time.LocalDateTime;

public record MyFundingAdminResponse(
        String myFundingId,
        Long userId,
        String fundingId,
        Long price,
        Status status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static MyFundingAdminResponse from(MyFunding myFunding) {
        return new MyFundingAdminResponse(
                myFunding.getMyFundingId(),
                myFunding.getUserId(),
                myFunding.getFundingId(),
                myFunding.getPrice(),
                myFunding.getStatus(),
                myFunding.getCreatedAt(),
                myFunding.getUpdatedAt()
        );
    }
}
