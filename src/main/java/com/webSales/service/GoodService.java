package com.webSales.service;

import com.webSales.dto.GoodDto;

import java.util.List;

public interface GoodService {
    GoodDto createGood(GoodDto goodDto);
    GoodDto getGoodById(Integer gooodId);
    List<GoodDto> getAllGood();
    GoodDto updateGood(Integer goodId, GoodDto updateGood);
    void deleteGood(Integer goodId);
}
