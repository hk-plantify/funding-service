package com.plantify.funding.contoller.funding;

import com.plantify.funding.domain.dto.funding.FundingAdminRequest;
import com.plantify.funding.domain.dto.funding.FundingAdminResponse;
import com.plantify.funding.domain.entity.Status;
import com.plantify.funding.global.response.ApiResponse;
import com.plantify.funding.service.funding.FundingAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/admin/funding")
public class FundingAdminController {

    private final FundingAdminService fundingAdminService;

    // 펀딩 생성
    @PostMapping
    public ApiResponse<FundingAdminResponse> createFunding(@RequestBody FundingAdminRequest request) {
        FundingAdminResponse response = fundingAdminService.createFunding(request);
        return ApiResponse.ok(response);
    }

    // 펀딩 수정
    @PutMapping("/{fundingId}")
    public ApiResponse<FundingAdminResponse> updateFunding(
            @PathVariable String fundingId, @RequestBody FundingAdminRequest request) {
        FundingAdminResponse response = fundingAdminService.updateFunding(fundingId, request);
        return ApiResponse.ok(response);
    }

    // 펀딩 삭제
    @DeleteMapping("/{fundingId}")
    public ApiResponse<Void> deleteFunding(@PathVariable String fundingId) {
        fundingAdminService.deleteFunding(fundingId);
        return ApiResponse.ok();
    }

    // 펀딩 상태 변경
    @PutMapping("/{fundingId}/status")
    public ApiResponse<FundingAdminResponse> updateFundingStatus(
            @PathVariable String fundingId, @RequestParam Status status) {
        FundingAdminResponse response = fundingAdminService.updateFundingStatus(fundingId, status);
        return ApiResponse.ok(response);
    }
}
