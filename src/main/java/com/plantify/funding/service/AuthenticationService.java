package com.plantify.funding.service;

import com.plantify.funding.domain.dto.response.UserResponse;

public interface AuthenticationService {

    void validateRole(String authorizationHeader);
    UserResponse getUserInfo(String authorizationHeader);

}
