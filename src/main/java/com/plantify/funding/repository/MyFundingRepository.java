package com.plantify.funding.repository;

import com.plantify.funding.domain.entity.MyFunding;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MyFundingRepository extends MongoRepository<MyFunding, Long> {
}
