package com.plantify.funding.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class Funding {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long fundingId;

    @Column(nullable = false)
    private String title;

    private String content;

    private String image;

    private Long curAmount;

    private Long targetAmount;

    private Double percent;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Enumerated(EnumType.STRING)
    private Category category;

    private LocalDateTime fundingStartDate;

    private LocalDateTime fundingEndDate;

    private LocalDateTime donationStartDate;

    private LocalDateTime donationEndDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizationId", nullable = false)
    private Organization organization;

    public Funding updateStatus(Status status) {
        this.status = status;
        return this;
    }

    public Funding increase(long amount) {
        this.curAmount += amount;
        this.percent = ((double) this.curAmount / this.targetAmount) * 100;
        return this;
    }

    public Funding decrease(long curAmount) {
        this.curAmount -= curAmount;
        this.percent = ((double) this.curAmount / this.targetAmount) * 100;
        return this;
    }
}
