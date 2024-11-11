package com.plantify.funding.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "funding")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Funding {

    @Id
    private Long fundingId;
    private Long organizationId;
    private Long myFundingId;
    private String title;
    private String content;
    private String image;
    private Long curAmount;
    private Long targetAmount;
    private Double percent;
    private Status status;
    private LocalDateTime fundingStartDate;
    private LocalDateTime fundingEndDate;
    private LocalDateTime donationStartDate;
    private LocalDateTime donationEndDate;
}
