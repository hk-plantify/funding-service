package com.plantify.funding.domain.dto.myFunding;

import com.plantify.funding.domain.entity.MyFunding;
import com.plantify.funding.domain.entity.Status;

public record MyFundingUserRequest(
        String fundingId,
        Long price
) {
    public MyFunding toEntity(Long userId) {
        return MyFunding.builder()
                .userId(userId)
                .fundingId(fundingId)
                .price(price)
                .status(Status.INPROGRESS)
                .build();
    }
}
