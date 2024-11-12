package com.plantify.funding.service;

import com.plantify.funding.contoller.client.AuthServiceClient;
import com.plantify.funding.domain.dto.response.UserResponse;
import com.plantify.funding.global.exception.ApplicationException;
import com.plantify.funding.global.exception.errorcode.AuthErrorCode;
import com.plantify.funding.global.exception.errorcode.FundingErrorCode;
import com.plantify.funding.global.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final AuthServiceClient authServiceClient;

    @Override
    public void validateRole(String authorizationHeader) {
        UserResponse userInfo = getUserInfo(authorizationHeader);
        String role = userInfo.role();
        if (!"MANAGER".equalsIgnoreCase(role) && !"ADMIN".equalsIgnoreCase(role)) {
            throw new ApplicationException(FundingErrorCode.FUNDING_ACCESS_DENIED);
        }
    }

    @Override
    public Long getAuthenticatedUserId(String authorizationHeader) {
        UserResponse userInfo = getUserInfo(authorizationHeader);
        return userInfo.kakaoId();
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

    @Override
    public ApplicationException createAuthException(HttpStatus status) {
        return switch (status) {
            case BAD_REQUEST -> new ApplicationException(AuthErrorCode.UNSUPPORTED_TOKEN);
            case UNAUTHORIZED -> new ApplicationException(AuthErrorCode.EXPIRED_TOKEN);
            default -> new ApplicationException(AuthErrorCode.INVALID_TOKEN);
        };
    }
}
