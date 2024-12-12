package com.plantify.funding.domain.dto.myFunding;

import java.time.LocalDateTime;

public record ExternalSettlementResponse(
        String orderId,
        String orderName,
        LocalDateTime createdAt,
        Long amount
) {
}
