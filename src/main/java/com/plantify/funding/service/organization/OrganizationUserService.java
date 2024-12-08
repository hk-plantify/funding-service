package com.plantify.funding.service.organization;

import com.plantify.funding.domain.dto.organization.OrganizationUserResponse;

import java.util.List;

public interface OrganizationUserService {

    List<OrganizationUserResponse> getAllOrganizations();
}
