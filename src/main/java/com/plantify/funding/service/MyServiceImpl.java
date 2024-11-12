package com.plantify.funding.service;

import com.plantify.funding.domain.dto.request.MyFundingRequest;
import com.plantify.funding.domain.dto.response.MyFundingResponse;
import com.plantify.funding.repository.MyFundingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyServiceImpl implements MyFundingService{

    private final MyFundingRepository myFundingRepository;

    @Override
    public List<MyFundingResponse> getAllMyFundings() {
        return List.of();
    }

    @Override
    public MyFundingResponse addMyFunding(MyFundingRequest request) {
        return null;
    }

    @Override
    public MyFundingResponse getMyFunding(MyFundingRequest request) {
        return null;
    }

    @Override
    public void deleteMyFunding(MyFundingRequest request) {

    }
}
