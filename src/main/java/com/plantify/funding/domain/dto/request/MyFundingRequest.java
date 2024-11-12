package com.plantify.funding.domain.dto.request;

import com.plantify.funding.domain.entity.MyFunding;
import com.plantify.funding.domain.entity.Status;

public record MyFundingRequest(Long userId, Long price, Status status) {

    public MyFunding toEntity() {
        return MyFunding.builder()
                .userId(userId)
                .price(price)
                .status(status)
                .build();
    }
}
