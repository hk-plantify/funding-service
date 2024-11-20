package com.plantify.funding.domain.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "funding")
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Funding {

    @Id
    private Long fundingId;
    private String title;
    private String content;
    private String image;
    private Long curAmount;
    private Long targetAmount;
    private Double percent;
    @JsonSerialize(using = ToStringSerializer.class)
    private Status status;
    private Category category;
    private LocalDateTime fundingStartDate;
    private LocalDateTime fundingEndDate;
    private LocalDateTime donationStartDate;
    private LocalDateTime donationEndDate;
}
