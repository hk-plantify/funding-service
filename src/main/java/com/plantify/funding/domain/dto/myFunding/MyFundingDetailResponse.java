package com.plantify.funding.domain.dto.myFunding;

import com.plantify.funding.domain.dto.funding.FundingResponse;
import com.plantify.funding.domain.entity.Funding;
import com.plantify.funding.domain.entity.MyFunding;
import com.plantify.funding.domain.entity.Status;

import java.time.LocalDateTime;

public record MyFundingDetailResponse(
        Long myFundingId,
        Long price,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        FundingResponse funding
) {
    public static MyFundingDetailResponse from(MyFunding myFunding) {
        return new MyFundingDetailResponse(
                myFunding.getMyFundingId(),
                myFunding.getPrice(),
                myFunding.getCreatedAt(),
                myFunding.getUpdatedAt(),
                FundingResponse.from(myFunding.getFunding())
        );
    }
}

