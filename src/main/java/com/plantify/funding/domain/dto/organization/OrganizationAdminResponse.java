package com.plantify.funding.domain.dto.organization;

import com.plantify.funding.domain.entity.Organization;

public record OrganizationAdminResponse(
        String organizationId,
        String name,
        String content
) {
    public static OrganizationAdminResponse from(Organization organization) {
        return new OrganizationAdminResponse(
                organization.getOrganizationId(),
                organization.getName(),
                organization.getContent()
        );
    }
}
