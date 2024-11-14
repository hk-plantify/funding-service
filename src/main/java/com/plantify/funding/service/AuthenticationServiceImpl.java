package com.plantify.funding.service;

import com.plantify.funding.contoller.client.AuthServiceClient;
import com.plantify.funding.domain.dto.response.UserResponse;
import com.plantify.funding.global.exception.ApplicationException;
import com.plantify.funding.global.exception.errorcode.FundingErrorCode;
import com.plantify.funding.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.plantify.funding.global.exception.ApplicationException.createAuthException;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final AuthServiceClient authServiceClient;
    private final List<String> roles;

    @Override
    public void validateRole(String authorizationHeader) {
        UserResponse userInfo = getUserInfo(authorizationHeader);
        String role = userInfo.role();
        if (!roles.contains(role)) {
            throw new ApplicationException(FundingErrorCode.FUNDING_ACCESS_DENIED);
        }
    }

    @Override
    public UserResponse getUserInfo(String authorizationHeader) {
        ApiResponse<UserResponse> response = authServiceClient.getUserInfo(authorizationHeader);
        if (response.getStatus() == HttpStatus.OK) {
            return response.getData();
        } else {
            throw createAuthException(response.getStatus());
        }
    }


}
