package com.plantify.funding.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "fCategory")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FCategory {

    @Id
    private Long categoryId;
    private Long fundingId;
    private String category;
}
