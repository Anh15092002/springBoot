package com.webSales.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailDto {
    private Integer id;
    private Integer order_id;
    private Integer good_id;
    private Integer quantity;
    private BigDecimal price;
    private BigDecimal discount;
}
