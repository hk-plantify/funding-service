package com.plantify.funding.contoller.organization;

import com.plantify.funding.domain.dto.organization.OrganizationAdminRequest;
import com.plantify.funding.domain.dto.organization.OrganizationAdminResponse;
import com.plantify.funding.global.response.ApiResponse;
import com.plantify.funding.service.organization.OrganizationAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/admin/funding/organizations")
public class OrganizationAdminController {

    private final OrganizationAdminService organizationAdminService;

    @PostMapping
    public ApiResponse<OrganizationAdminResponse> createOrganization(
            @RequestBody OrganizationAdminRequest request) {
        OrganizationAdminResponse response = organizationAdminService.createOrganization(request);
        return ApiResponse.ok(response);
    }

    @PutMapping("/{organizationId}")
    public ApiResponse<OrganizationAdminResponse> updateOrganization(
            @PathVariable String organizationId, @RequestBody OrganizationAdminRequest request) {
        OrganizationAdminResponse response = organizationAdminService.updateOrganization(organizationId, request);
        return ApiResponse.ok(response);
    }

    @DeleteMapping("/{organizationId}")
    public ApiResponse<Void> deleteOrganization(@PathVariable String organizationId) {
        organizationAdminService.deleteOrganization(organizationId);
        return ApiResponse.ok();
    }
}
