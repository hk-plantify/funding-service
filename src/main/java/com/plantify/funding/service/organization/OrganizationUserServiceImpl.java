package com.plantify.funding.service.organization;

import com.plantify.funding.domain.dto.organization.OrganizationUserResponse;
import com.plantify.funding.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizationUserServiceImpl implements OrganizationUserService {

    private final OrganizationRepository organizationRepository;

    @Override
    public List<OrganizationUserResponse> getAllOrganizations() {
        return organizationRepository.findAll()
                .stream()
                .map(OrganizationUserResponse::from)
                .toList();
    }
}
