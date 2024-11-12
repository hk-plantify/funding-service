package com.plantify.funding.repository;

import com.plantify.funding.domain.entity.Funding;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FundingRepository extends MongoRepository<Funding, Long> {
}
