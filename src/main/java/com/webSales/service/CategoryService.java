package com.webSales.service;

import com.webSales.dto.CategoryDto;
import com.webSales.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Integer categoryId);

    List<CategoryDto> getAllCategory();

    CategoryDto updateCategory(Integer categoryId, CategoryDto updateCategory);

    void deleteCategory(Integer categoryId);
}
