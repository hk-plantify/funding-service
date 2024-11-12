package com.plantify.funding.domain.dto.response;

import com.plantify.funding.domain.entity.MyFunding;
import com.plantify.funding.domain.entity.Status;

import java.time.LocalDateTime;

public record MyFundingResponse(
        Long myFundingId,
        Long userId,
        Long price,
        LocalDateTime createdAt,
        Status status
) {
    public static MyFundingResponse from(MyFunding myFunding) {
        return new MyFundingResponse(
                myFunding.getMyFundingId(),
                myFunding.getUserId(),
                myFunding.getPrice(),
                myFunding.getCreatedAt(),
                myFunding.getStatus()
        );
    }
}
