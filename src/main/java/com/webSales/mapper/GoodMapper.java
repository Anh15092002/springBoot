package com.webSales.mapper;

import com.webSales.dto.GoodDto;
import com.webSales.entity.Category;
import com.webSales.entity.Good;

public class GoodMapper {
    public static GoodDto mapToGoodDto(Good good) {
        return new GoodDto(
                good.getId(),
                good.getName(),
                good.getPrice(),
                good.getStock_quantity(),
                good.getDescription(),
                good.getImage_url(),
                good.getCategory_id().getId()
        );
    }

    public static Good mapToGood(GoodDto goodDto) {
        if (goodDto == null) {
            return null;
        }

        Good good = new Good();
        good.setId(goodDto.getId());
        good.setName(goodDto.getName());
        good.setPrice(goodDto.getPrice());
        good.setStock_quantity(goodDto.getStock_quantity());
        good.setDescription(goodDto.getDescription());
        good.setImage_url(goodDto.getImage_url());

        if (goodDto.getCategory_id() != null) {
            Category category = new Category();
            category.setId(goodDto.getCategory_id());
            good.setCategory_id(category);
        }

        return good;
    }
}
