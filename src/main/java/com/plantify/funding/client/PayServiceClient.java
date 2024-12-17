package com.plantify.funding.client;

import com.plantify.funding.domain.dto.myFunding.ExternalSettlementResponse;
import com.plantify.funding.domain.dto.myFunding.PaymentResponse;
import com.plantify.funding.domain.dto.myFunding.PendingTransactionRequest;
import com.plantify.funding.global.response.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "pay-service", url = "${pay.service.url}")
public interface PayServiceClient {

    @PostMapping("/v1/pay/payment")
    ResponseEntity<PaymentResponse> initiatePayment(@RequestBody PendingTransactionRequest request);

    @GetMapping("/v1/pay/settlements/external")
    ResponseEntity<ExternalSettlementResponse> getSettlementByOrderId(@RequestParam String orderId);
}