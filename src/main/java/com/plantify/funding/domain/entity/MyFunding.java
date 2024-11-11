package com.plantify.funding.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "myFunding")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MyFunding {

    @Id
    private Long myFundingId;
    private Long userId;
    private Long price;
    private Date createdAt;
    private Status status;
}
