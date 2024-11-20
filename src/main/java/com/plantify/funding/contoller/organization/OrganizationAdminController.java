package com.plantify.funding.contoller.organization;

import com.plantify.funding.domain.dto.organization.OrganizationAdminRequest;
import com.plantify.funding.domain.dto.organization.OrganizationAdminResponse;
import com.plantify.funding.domain.dto.organization.OrganizationUserResponse;
import com.plantify.funding.global.response.ApiResponse;
import com.plantify.funding.service.organization.OrganizationAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/admin/funding/organizations")
public class OrganizationAdminController {

    private final OrganizationAdminService organizationAdminService;

    @PostMapping
    public ResponseEntity<ApiResponse<OrganizationAdminResponse>> createOrganization(
            @RequestBody OrganizationAdminRequest request) {
        OrganizationAdminResponse response = organizationAdminService.createOrganization(request);
        return ResponseEntity.ok(ApiResponse.ok(response));
    }

    @PutMapping("/{organizationId}")
    public ResponseEntity<ApiResponse<OrganizationAdminResponse>> updateOrganization(
            @PathVariable Long organizationId, @RequestBody OrganizationAdminRequest request) {
        OrganizationAdminResponse response = organizationAdminService.updateOrganization(organizationId, request);
        return ResponseEntity.ok(ApiResponse.ok(response));
    }

    @DeleteMapping("/{organizationId}")
    public ResponseEntity<ApiResponse<Void>> deleteOrganization(@PathVariable Long organizationId) {
        organizationAdminService.deleteOrganization(organizationId);
        return ResponseEntity.ok(ApiResponse.ok());
    }
}
