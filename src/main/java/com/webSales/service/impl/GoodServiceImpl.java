package com.webSales.service.impl;

import com.webSales.dto.GoodDto;
import com.webSales.entity.Category;
import com.webSales.entity.Good;
import com.webSales.exception.ResourceNotFoundException;
import com.webSales.mapper.GoodMapper;
import com.webSales.repository.CategoryRepository;
import com.webSales.repository.GoodRespository;
import com.webSales.service.GoodService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoodServiceImpl implements GoodService {
    private GoodRespository goodRespository;
    private CategoryRepository categoryRepository;

    @Override
    public GoodDto createGood(GoodDto goodDto) {
        Good good = GoodMapper.mapToGood(goodDto);
        Good savedGood = goodRespository.save(good);
        return GoodMapper.mapToGoodDto(savedGood);
    }

    @Override
    public GoodDto getGoodById(Integer gooodId) {
        Good good = goodRespository.findById(gooodId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Good is not exist woth given id: " + gooodId));
        return GoodMapper.mapToGoodDto(good);
    }

    @Override
    public List<GoodDto> getAllGood() {
        List<Good> goods = goodRespository.findAll();
        return goods.stream().map((good -> GoodMapper.mapToGoodDto(good)))
                .collect(Collectors.toList());
    }

    @Override
    public GoodDto updateGood(Integer goodId, GoodDto updateGood) {
        Good good = goodRespository.findById(goodId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Good is not exist with given id: " + goodId));
        good.setName(updateGood.getName());
        good.setPrice(updateGood.getPrice());
        good.setStock_quantity(updateGood.getStock_quantity());
        good.setDescription(updateGood.getDescription());
        good.setImage_url(updateGood.getImage_url());
        if (updateGood.getCategory_id() != null) {
            Category category = categoryRepository.findById(updateGood.getCategory_id())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Category is not exist with given id: " + updateGood.getCategory_id()));
            good.setCategory_id(category);
        }
        Good updateGoodObj = goodRespository.save(good);
        return GoodMapper.mapToGoodDto(updateGoodObj);
    }

    @Override
    public void deleteGood(Integer goodId) {
        Good good = goodRespository.findById(goodId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Good is not exist with given id: " + goodId));
        goodRespository.deleteById(goodId);
    }
}
