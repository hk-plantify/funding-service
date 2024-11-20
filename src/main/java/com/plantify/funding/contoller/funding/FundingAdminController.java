package com.plantify.funding.contoller.funding;

import com.plantify.funding.domain.dto.funding.FundingAdminRequest;
import com.plantify.funding.domain.dto.funding.FundingAdminResponse;
import com.plantify.funding.domain.entity.Status;
import com.plantify.funding.global.response.ApiResponse;
import com.plantify.funding.service.funding.FundingAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/admin/funding")
public class FundingAdminController {

    private final FundingAdminService fundingAdminService;

    // 펀딩 생성
    @PostMapping
    public ResponseEntity<ApiResponse<FundingAdminResponse>> createFunding(@RequestBody FundingAdminRequest request) {
        FundingAdminResponse response = fundingAdminService.createFunding(request);
        return ResponseEntity.ok(ApiResponse.ok(response));
    }

    // 펀딩 수정
    @PutMapping("/{fundingId}")
    public ResponseEntity<ApiResponse<FundingAdminResponse>> updateFunding(
            @PathVariable Long fundingId, @RequestBody FundingAdminRequest request) {
        FundingAdminResponse response = fundingAdminService.updateFunding(fundingId, request);
        return ResponseEntity.ok(ApiResponse.ok(response));
    }

    // 펀딩 삭제
    @DeleteMapping("/{fundingId}")
    public ResponseEntity<ApiResponse<Void>> deleteFunding(@PathVariable Long fundingId) {
        fundingAdminService.deleteFunding(fundingId);
        return ResponseEntity.ok(ApiResponse.ok());
    }

    // 펀딩 상태 변경
    @PutMapping("/{fundingId}/status")
    public ResponseEntity<ApiResponse<FundingAdminResponse>> updateFundingStatus(
            @PathVariable Long fundingId, @RequestParam Status status) {
        FundingAdminResponse response = fundingAdminService.updateFundingStatus(fundingId, status);
        return ResponseEntity.ok(ApiResponse.ok(response));
    }
}
