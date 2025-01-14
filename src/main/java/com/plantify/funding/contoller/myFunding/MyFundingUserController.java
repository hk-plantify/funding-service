package com.plantify.funding.contoller.myFunding;

import com.plantify.funding.domain.dto.myFunding.MyFundingDetailResponse;
import com.plantify.funding.domain.dto.myFunding.MyFundingUserRequest;
import com.plantify.funding.domain.dto.myFunding.MyFundingUserResponse;
import com.plantify.funding.global.response.ApiResponse;
import com.plantify.funding.service.myFunding.MyFundingUserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/funding/my-funding")
public class MyFundingUserController {

    private final MyFundingUserService myFundingUserService;

    // 자신의 모든 참여중 펀딩 조회
    @GetMapping
    public ApiResponse<Page<MyFundingDetailResponse>> getMyFunding(Pageable pageable) {
        Page<MyFundingDetailResponse> funding = myFundingUserService.getMyFunding(pageable);
        return ApiResponse.ok(funding);
    }

    // 자신의 참여중 펀딩 상세 조회
    @GetMapping("/{myFundingId}")
    public ApiResponse<MyFundingDetailResponse> getMyFundingDetails(@PathVariable Long myFundingId) {
        MyFundingDetailResponse response = myFundingUserService.getMyFundingDetails(myFundingId);
        return ApiResponse.ok(response);
    }

    // 펀딩 참여
    @PostMapping
    public ApiResponse<String> createMyFunding(@RequestBody MyFundingUserRequest request) {
        String token = myFundingUserService.participate(request);
        return ApiResponse.ok(token);
    }

    @GetMapping("/callback")
    public ApiResponse<MyFundingUserResponse> getMyFundingUserCallback(@RequestParam String orderId) {
        MyFundingUserResponse response = myFundingUserService.callbackParticipate(orderId);
        return ApiResponse.ok(response);
    }

    // 펀딩에 참여 취소
    @PutMapping("/{myFundingId}")
    public ApiResponse<MyFundingUserResponse> updateMyFunding(
            @PathVariable Long myFundingId, @RequestBody MyFundingUserRequest request) {
        MyFundingUserResponse response = myFundingUserService.cancel(myFundingId, request);
        return ApiResponse.ok(response);
    }
}
