package com.plantify.funding.repository;

import com.plantify.funding.domain.entity.Organization;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrganizationRepository extends MongoRepository<Organization, String> {
}
