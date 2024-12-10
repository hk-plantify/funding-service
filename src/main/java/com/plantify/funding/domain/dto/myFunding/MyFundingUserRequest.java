package com.plantify.funding.domain.dto.myFunding;

import com.plantify.funding.domain.entity.Funding;
import com.plantify.funding.domain.entity.MyFunding;

public record MyFundingUserRequest(
        Long fundingId,
        Long price
) {
    public MyFunding toEntity(Long userId, Funding funding) {
        return MyFunding.builder()
                .userId(userId)
                .price(price)
                .funding(funding)
                .build();
    }
}
