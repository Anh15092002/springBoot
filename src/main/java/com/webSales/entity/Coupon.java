package com.webSales.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coupon")
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", length = 20, unique = true, nullable = false)
    private String code;

    @Column(name = "discount", precision = 5, scale = 2, nullable = false)
    private BigDecimal discount;

    @Column(name = "expriation_date")
    private Date expriation_date;
}
