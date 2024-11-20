package com.plantify.funding.service.organization;

import com.plantify.funding.domain.dto.organization.OrganizationAdminRequest;
import com.plantify.funding.domain.dto.organization.OrganizationAdminResponse;
import com.plantify.funding.domain.dto.organization.OrganizationUserResponse;
import com.plantify.funding.domain.entity.Organization;
import com.plantify.funding.global.exception.ApplicationException;
import com.plantify.funding.global.exception.errorcode.OrganizationErrorCode;
import com.plantify.funding.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrganizationAdminServiceImpl implements OrganizationAdminService {

    private final OrganizationRepository organizationRepository;

    @Override
    public OrganizationAdminResponse createOrganization(OrganizationAdminRequest request) {
        Organization organization = request.toEntity();
        Organization savedOrganization = organizationRepository.save(organization);
        return OrganizationAdminResponse.from(savedOrganization);
    }

    @Override
    public OrganizationAdminResponse updateOrganization(Long organizationId, OrganizationAdminRequest request) {
        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new ApplicationException(OrganizationErrorCode.ORGANIZATION_NOT_FOUND));

        Organization updatedOrganization = organization.toBuilder()
                .name(request.name())
                .content(request.content())
                .build();

        organizationRepository.save(updatedOrganization);
        return OrganizationAdminResponse.from(updatedOrganization);
    }

    @Override
    public void deleteOrganization(Long organizationId) {
        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new ApplicationException(OrganizationErrorCode.ORGANIZATION_NOT_FOUND));
        organizationRepository.delete(organization);
    }
}
