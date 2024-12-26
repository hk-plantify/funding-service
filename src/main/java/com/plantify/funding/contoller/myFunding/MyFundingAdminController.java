package com.plantify.funding.contoller.myFunding;

import com.plantify.funding.domain.dto.myFunding.MyFundingAdminResponse;
import com.plantify.funding.global.response.ApiResponse;
import com.plantify.funding.service.myFunding.MyFundingAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/admin/funding/my-funding")
public class MyFundingAdminController {

    private final MyFundingAdminService myFundingAdminService;

    // 모든 사용자 참여 펀딩 조회
    @GetMapping
    public ApiResponse<List<MyFundingAdminResponse>> getAllFunding() {
        List<MyFundingAdminResponse> responses = myFundingAdminService.getAllFunding();
        return ApiResponse.ok(responses);
    }

    // 특정 참여 펀딩 상세 조회
    @GetMapping("/{myFundingId}")
    public ApiResponse<MyFundingAdminResponse> getMyFundingDetails(@PathVariable Long myFundingId) {
        MyFundingAdminResponse response = myFundingAdminService.getMyFundingDetails(myFundingId);
        return ApiResponse.ok(response);
    }

    // 특정 사용자의 모든 참여 펀딩 조회
    @GetMapping("/users/{userId}")
    public ApiResponse<List<MyFundingAdminResponse>> getUserFunding(@PathVariable Long userId) {
        List<MyFundingAdminResponse> responses = myFundingAdminService.getUserFunding(userId);
        return ApiResponse.ok(responses);
    }
}
