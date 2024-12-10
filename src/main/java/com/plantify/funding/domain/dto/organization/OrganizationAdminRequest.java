package com.plantify.funding.domain.dto.organization;

import com.plantify.funding.domain.entity.Organization;

public record OrganizationAdminRequest(
        String name,
        String content
) {
    public Organization toEntity() {
        return Organization.builder()
                .name(name)
                .content(content)
                .build();
    }
}