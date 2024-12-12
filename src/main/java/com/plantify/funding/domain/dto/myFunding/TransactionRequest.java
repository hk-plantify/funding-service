package com.plantify.funding.domain.dto.myFunding;

public record TransactionRequest(
        Long userId,
        Long sellerId,
        String orderName,
        Long amount,
        String transactionType,
        String reason,
        String redirectUri
) {
}
