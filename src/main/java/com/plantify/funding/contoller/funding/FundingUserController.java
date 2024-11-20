package com.plantify.funding.contoller.funding;

import com.plantify.funding.domain.dto.funding.FundingUserResponse;
import com.plantify.funding.global.response.ApiResponse;
import com.plantify.funding.service.funding.FundingUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/funding")
public class FundingUserController {

    private final FundingUserService fundingUserService;

    // 모든 펀딩 조회
    @GetMapping
    public ResponseEntity<ApiResponse<Page<FundingUserResponse>>> getAllFunding(Pageable pageable) {
        Page<FundingUserResponse> funding = fundingUserService.getAllFunding(pageable);
        return ResponseEntity.ok(ApiResponse.ok(funding));
    }

    // 특정 펀딩 조회
    @GetMapping("/{fundingId}")
    public ResponseEntity<ApiResponse<FundingUserResponse>> getFundingById(@PathVariable Long fundingId) {
        FundingUserResponse response = fundingUserService.getFundingById(fundingId);
        return ResponseEntity.ok(ApiResponse.ok(response));
    }
}
