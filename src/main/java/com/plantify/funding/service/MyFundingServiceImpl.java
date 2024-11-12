package com.plantify.funding.service;

import com.plantify.funding.domain.dto.request.MyFundingRequest;
import com.plantify.funding.domain.dto.response.FundingResponse;
import com.plantify.funding.domain.dto.response.MyFundingResponse;
import com.plantify.funding.domain.dto.response.UserResponse;
import com.plantify.funding.domain.entity.Funding;
import com.plantify.funding.domain.entity.MyFunding;
import com.plantify.funding.global.exception.ApplicationException;
import com.plantify.funding.global.exception.errorcode.FundingErrorCode;
import com.plantify.funding.repository.FundingRepository;
import com.plantify.funding.repository.MyFundingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MyFundingServiceImpl implements MyFundingService{

    private final MyFundingRepository myFundingRepository;
    private final FundingRepository fundingRepository;
    private final AuthenticationService authenticationService;

    @Override
    public List<MyFundingResponse> getAllMyFundings(String authorizationHeader) {
        Long kakaoId = authenticationService.getAuthenticatedUserId(authorizationHeader);
        return myFundingRepository.findByUserId(kakaoId)
                .stream()
                .map(MyFundingResponse::from)
                .collect(Collectors.toList());
    }

    @Override
    public FundingResponse getMyFunding(String authorizationHeader, Long fundingId) {
        Long kakaoId = authenticationService.getAuthenticatedUserId(authorizationHeader);
        boolean isParticipated = myFundingRepository.existsByUserIdAndFundingId(kakaoId, fundingId);
        if (!isParticipated) {
            throw new ApplicationException(FundingErrorCode.FUNDING_ACCESS_DENIED);
        }
        Funding funding = fundingRepository.findById(fundingId)
                .orElseThrow(() -> new ApplicationException(FundingErrorCode.FUNDING_NOT_FOUND));
        return FundingResponse.from(funding);
    }

    @Override
    public MyFundingResponse addMyFunding(String authorizationHeader, MyFundingRequest request) {
        Long kakaoId = authenticationService.getAuthenticatedUserId(authorizationHeader);
        MyFunding myFunding = request.toEntity(kakaoId);
        MyFunding savedMyFunding = myFundingRepository.save(myFunding);
        return MyFundingResponse.from(savedMyFunding);
    }

    @Override
    public void deleteMyFunding(String authorizationHeader, Long myFundingId) {
        Long kakaoId = authenticationService.getAuthenticatedUserId(authorizationHeader);
        MyFunding myFunding = myFundingRepository.findByUserIdAndMyFundingId(kakaoId, myFundingId)
                .orElseThrow(() -> new ApplicationException(FundingErrorCode.FUNDING_NOT_FOUND));
        myFundingRepository.delete(myFunding);
    }
}
