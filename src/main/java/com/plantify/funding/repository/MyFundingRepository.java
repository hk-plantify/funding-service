package com.plantify.funding.repository;

import com.plantify.funding.domain.entity.MyFunding;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MyFundingRepository extends MongoRepository<MyFunding, Long> {

    boolean existsByUserIdAndFundingId(Long kakaoId, Long fundingId);
    List<MyFunding> findByUserId(Long kakaoId);
    Optional<MyFunding> findByUserIdAndMyFundingId(Long kakaoId, Long myFundingId);
}
