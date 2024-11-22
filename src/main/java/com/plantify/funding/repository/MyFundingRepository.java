package com.plantify.funding.repository;

import com.plantify.funding.domain.entity.MyFunding;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MyFundingRepository extends MongoRepository<MyFunding, String> {

    List<MyFunding> findByUserId(Long userId);
    Page<MyFunding> findAllByUserId(Pageable pageable, Long userId);
    Optional<MyFunding> findByUserIdAndFundingId(Long userId, String fundingId);
    Optional<MyFunding> findByMyFundingIdAndUserId(String myFundingId, Long userId);
}
