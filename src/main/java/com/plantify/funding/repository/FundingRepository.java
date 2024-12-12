package com.plantify.funding.repository;

import com.plantify.funding.domain.entity.Category;
import com.plantify.funding.domain.entity.Funding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FundingRepository extends JpaRepository<Funding, Long> {

    Page<Funding> findByCategory(Category category, Pageable pageable);
    Optional<Funding> findByTitle(String title);
}
