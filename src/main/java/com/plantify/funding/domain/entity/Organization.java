package com.plantify.funding.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "organization")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Organization extends BaseEntity {

    @Id
    private Long organizationId;
    private String name;
    private String content;
}
