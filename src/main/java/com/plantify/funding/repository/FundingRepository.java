package com.plantify.funding.repository;

import com.plantify.funding.domain.entity.Category;
import com.plantify.funding.domain.entity.Funding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FundingRepository extends MongoRepository<Funding, String> {

    Page<Funding> findByCategory(Category category, Pageable pageable);
}
