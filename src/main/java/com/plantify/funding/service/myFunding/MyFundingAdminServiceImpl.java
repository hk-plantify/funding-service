package com.plantify.funding.service.myFunding;

import com.plantify.funding.domain.dto.myFunding.MyFundingAdminResponse;
import com.plantify.funding.domain.entity.MyFunding;
import com.plantify.funding.global.exception.ApplicationException;
import com.plantify.funding.global.exception.errorcode.MyFundingErrorCode;
import com.plantify.funding.repository.MyFundingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyFundingAdminServiceImpl implements MyFundingAdminService {

    private final MyFundingRepository myFundingRepository;

    @Override
    public List<MyFundingAdminResponse> getAllFunding() {
        return myFundingRepository.findAll().stream()
                .map(MyFundingAdminResponse::from)
                .toList();
    }

    @Override
    public MyFundingAdminResponse getMyFundingDetails(String myFundingId) {
        MyFunding myFunding = myFundingRepository.findById(myFundingId)
                .orElseThrow(() -> new ApplicationException(MyFundingErrorCode.FUNDING_NOT_FOUND));
        return MyFundingAdminResponse.from(myFunding);
    }

    @Override
    public List<MyFundingAdminResponse> getUserFunding(Long userId) {
        return myFundingRepository.findByUserId(userId).stream()
                .map(MyFundingAdminResponse::from)
                .toList();
    }
}
