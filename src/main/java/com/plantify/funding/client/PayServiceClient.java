package com.plantify.funding.client;

import com.plantify.funding.domain.dto.myFunding.TransactionRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "pay-service", url = "${pay.service.url}")
public interface PayServiceClient {

    @PostMapping("/v1/pay/payment")
    void payment(@RequestBody TransactionRequest request);
}
