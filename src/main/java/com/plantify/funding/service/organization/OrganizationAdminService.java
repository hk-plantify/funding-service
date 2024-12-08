package com.plantify.funding.service.organization;

import com.plantify.funding.domain.dto.organization.OrganizationAdminRequest;
import com.plantify.funding.domain.dto.organization.OrganizationAdminResponse;

public interface OrganizationAdminService {

    OrganizationAdminResponse createOrganization(OrganizationAdminRequest request);
    OrganizationAdminResponse updateOrganization(Long organizationId, OrganizationAdminRequest request);
    void deleteOrganization(Long organizationId);
}
