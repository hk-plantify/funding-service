package com.plantify.funding.domain.dto.myFunding;

public record TransactionRequest(
        Long userId,
        Long sellerId,
        Long orderId,
        String orderName,
        Long amount,
        String transactionType,
        String reason,
        Long pointToUse
) {
}
