package com.plantify.funding.repository;

import com.plantify.funding.domain.entity.MyFunding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MyFundingRepository extends JpaRepository<MyFunding, Long> {

    List<MyFunding> findByUserId(Long userId);
    Page<MyFunding> findAllByUserId(Long userId, Pageable pageable);
    Optional<MyFunding> findByMyFundingIdAndUserId(Long myFundingId, Long userId);
}
