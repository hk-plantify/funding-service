package com.plantify.funding.domain.dto.organization;

import com.plantify.funding.domain.entity.Organization;

public record OrganizationUserResponse(
        Long organizationId,
        String name,
        String content
) {
    public static OrganizationUserResponse from(Organization organization) {
        return new OrganizationUserResponse(
                organization.getOrganizationId(),
                organization.getName(),
                organization.getContent()
        );
    }
}
