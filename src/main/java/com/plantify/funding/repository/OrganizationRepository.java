package com.plantify.funding.repository;

import com.plantify.funding.domain.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizationRepository extends JpaRepository<Organization, Long> {

    Optional<Organization> findByName(String name);
}
