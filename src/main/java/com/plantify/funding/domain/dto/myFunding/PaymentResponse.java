package com.plantify.funding.domain.dto.myFunding;

import java.time.LocalDateTime;

public record PaymentResponse(
        Long transactionId,
        Long userId,
        Long paymentId,
        String orderId,
        String orderName,
        Long sellerId,
        Long amount,
        String status,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String token,
        String redirectUri
) {

}
