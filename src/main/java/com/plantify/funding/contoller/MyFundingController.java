package com.plantify.funding.contoller;

import com.plantify.funding.domain.dto.request.MyFundingRequest;
import com.plantify.funding.domain.dto.response.FundingResponse;
import com.plantify.funding.domain.dto.response.MyFundingResponse;
import com.plantify.funding.global.response.ApiResponse;
import com.plantify.funding.service.MyFundingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("v1/fundings/my-fundings")
public class MyFundingController {

    private final MyFundingService myFundingService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<MyFundingResponse>>> getAllMyFundings(
            @RequestHeader String authorizationHeader) {
        List<MyFundingResponse> myFundings = myFundingService.getAllMyFundings(authorizationHeader);
        return ResponseEntity.ok(ApiResponse.ok(myFundings));
    }

    @GetMapping("/{fundingId}")
    public ResponseEntity<ApiResponse<FundingResponse>> getMyFunding(
            @RequestHeader String authorizationHeader, @PathVariable Long fundingId) {
        FundingResponse funding = myFundingService.getMyFunding(authorizationHeader, fundingId);
        return ResponseEntity.ok(ApiResponse.ok(funding));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<MyFundingResponse>> addMyFunding(
            @RequestHeader String authorizationHeader, @RequestBody MyFundingRequest myFundingRequest) {
        MyFundingResponse myFundingResponse = myFundingService.addMyFunding(authorizationHeader, myFundingRequest);
        return ResponseEntity.ok(ApiResponse.ok(myFundingResponse));
    }

    @DeleteMapping("/{myFundingId}")
    public ResponseEntity<ApiResponse<Void>> deleteMyFunding(
            @RequestHeader String authorizationHeader, @PathVariable Long myFundingId) {
        myFundingService.deleteMyFunding(authorizationHeader, myFundingId);
        return ResponseEntity.ok(ApiResponse.ok());
    }
}
