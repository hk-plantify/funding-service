package com.plantify.funding.contoller;

import com.plantify.funding.domain.dto.request.FundingRequest;
import com.plantify.funding.domain.dto.response.FundingResponse;
import com.plantify.funding.global.response.ApiResponse;
import com.plantify.funding.service.FundingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/fundings")
public class FundingController {

    private final FundingService fundingService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<FundingResponse>>> getAllFundings() {
        List<FundingResponse> allFundings = fundingService.getAllFundings();
        return ResponseEntity.ok(ApiResponse.ok(allFundings));
    }

    @GetMapping("/{fundingId}")
    public ResponseEntity<ApiResponse<FundingResponse>> getFunding(@PathVariable Long fundingId) {
        FundingResponse funding = fundingService.getFunding(fundingId);
        return ResponseEntity.ok(ApiResponse.ok(funding));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<FundingResponse>> createFunding(
            @RequestHeader String authorizationHeader, @RequestBody FundingRequest fundingRequest) {
        FundingResponse fundingResponse = fundingService.addFunding(authorizationHeader, fundingRequest);
        return ResponseEntity.ok(ApiResponse.ok(fundingResponse));
    }

    @PutMapping("/{fundingId}")
    public ResponseEntity<ApiResponse<FundingResponse>> updateFunding(
            @RequestHeader String authorizationHeader, @PathVariable Long fundingId, @RequestBody FundingRequest fundingRequest) {
        FundingResponse fundingResponse = fundingService.updateFunding(authorizationHeader, fundingId, fundingRequest);
        return ResponseEntity.ok(ApiResponse.ok(fundingResponse));
    }

    @DeleteMapping("/{fundingId}")
    public ResponseEntity<ApiResponse<Void>> deleteFunding(
            @RequestHeader String authorizationHeader, @PathVariable Long fundingId) {
        fundingService.deleteFunding(authorizationHeader, fundingId);
        return ResponseEntity.ok(ApiResponse.ok());
    }
}
