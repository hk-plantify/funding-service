package com.plantify.funding.domain.dto.myFunding;

import com.plantify.funding.domain.entity.MyFunding;

public record MyFundingUserRequest(
        Long fundingId,
        Long price,
        Long pointToUse
) {
    public MyFunding toEntity(Long userId) {
        return MyFunding.builder()
                .userId(userId)
                .price(price)
                .build();
    }
}
