package com.toy.cryptoautomessage.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "report_histories")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReportHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String market;
    private String price;
    private LocalDateTime reprotedAt;

    public ReportHistory(String market, String price){
        this.market = market;
        this.price = price;
        this.reprotedAt = LocalDateTime.now();
    }
}
