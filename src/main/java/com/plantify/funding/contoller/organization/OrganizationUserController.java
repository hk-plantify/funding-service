package com.plantify.funding.contoller.organization;

import com.plantify.funding.domain.dto.organization.OrganizationUserResponse;
import com.plantify.funding.global.response.ApiResponse;
import com.plantify.funding.service.organization.OrganizationUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/funding/organizations")
public class OrganizationUserController {

    private final OrganizationUserService organizationUserService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<OrganizationUserResponse>>> getAllOrganizations() {
        List<OrganizationUserResponse> organizations = organizationUserService.getAllOrganizations();
        return ResponseEntity.ok(ApiResponse.ok(organizations));
    }
}
