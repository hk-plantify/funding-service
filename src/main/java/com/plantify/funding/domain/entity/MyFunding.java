package com.plantify.funding.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MyFunding extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long myFundingId;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fundingId", nullable = false)
    private Funding funding;

    public MyFunding participation(long price) {
        this.price += price;
        return this;
    }

    public MyFunding cancellation(long price) {
        this.price -= price;
        return this;
    }
}
