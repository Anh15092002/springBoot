package com.webSales.dto;

import com.webSales.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoodDto {
    private Integer id;
    private String name;
    private BigDecimal price;
    private Integer stock_quantity;
    private String description;
    private String image_url;
    private Integer category_id;
}
