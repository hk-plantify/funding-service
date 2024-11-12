package com.plantify.funding.domain.dto.request;

import com.plantify.funding.domain.entity.MyFunding;
import com.plantify.funding.domain.entity.Status;

public record MyFundingRequest(Long price, Status status) {

    public MyFunding toEntity(Long kakaoId) {
        return MyFunding.builder()
                .userId(kakaoId)
                .price(price)
                .status(status)
                .build();
    }
}
