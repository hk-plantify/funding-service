package com.plantify.funding.service;

import com.plantify.funding.domain.dto.response.UserResponse;
import com.plantify.funding.global.exception.ApplicationException;
import org.springframework.http.HttpStatus;

public interface AuthenticationService {

    void validateRole(String authorizationHeader);
    Long getAuthenticatedUserId(String authorizationHeader);
    UserResponse getUserInfo(String authorizationHeader);
    ApplicationException createAuthException(HttpStatus status);
}
