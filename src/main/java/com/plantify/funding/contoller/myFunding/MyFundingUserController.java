package com.plantify.funding.contoller.myFunding;

import com.plantify.funding.domain.dto.myFunding.MyFundingUserRequest;
import com.plantify.funding.domain.dto.myFunding.MyFundingUserResponse;
import com.plantify.funding.global.response.ApiResponse;
import com.plantify.funding.service.myFunding.MyFundingUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/funding/my-funding")
public class MyFundingUserController {

    private final MyFundingUserService myFundingUserService;

    // 자신의 모든 참여중 펀딩 조회
    @GetMapping
    public ApiResponse<Page<MyFundingUserResponse>> getMyFunding(Pageable pageable) {
        Page<MyFundingUserResponse> funding = myFundingUserService.getMyFunding(pageable);
        return ApiResponse.ok(funding);
    }

    // 자신의 참여중 펀딩 상세 조회
    @GetMapping("/{myFundingId}")
    public ApiResponse<MyFundingUserResponse> getMyFundingDetails(@PathVariable String myFundingId) {
        MyFundingUserResponse response = myFundingUserService.getMyFundingDetails(myFundingId);
        return ApiResponse.ok(response);
    }

    // 펀딩에 참여
    @PostMapping
    public ApiResponse<MyFundingUserResponse> createMyFunding(@RequestBody MyFundingUserRequest request) {
        MyFundingUserResponse response = myFundingUserService.createMyFunding(request);
        return ApiResponse.ok(response);
    }

    // 펀딩에 참여 취소
    @PutMapping("/{myFundingId}")
    public ApiResponse<MyFundingUserResponse> updateMyFunding(
            @PathVariable String myFundingId, @RequestBody MyFundingUserRequest request) {
        MyFundingUserResponse response = myFundingUserService.updateMyFunding(myFundingId, request);
        return ApiResponse.ok(response);
    }
}
