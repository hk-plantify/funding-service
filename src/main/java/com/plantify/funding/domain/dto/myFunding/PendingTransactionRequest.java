package com.plantify.funding.domain.dto.myFunding;

public record PendingTransactionRequest(
        Long userId,
        Long sellerId,
        String orderName,
        Long amount,
        String status,
        String redirectUri
) {
}
