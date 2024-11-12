package com.plantify.funding.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "myFunding")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyFunding {

    @Id
    private Long myFundingId;
    private Long userId;
    private Long fundingId;
    private Long price;
    @CreatedDate
    private LocalDateTime createdAt;
    private Status status;
}
