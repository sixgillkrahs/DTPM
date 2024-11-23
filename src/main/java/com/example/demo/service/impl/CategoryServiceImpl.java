package com.example.demo.service.impl;

import com.example.demo.common.dto.ResponseAPI;
import com.example.demo.dto.categories.CategoryDto;
import com.example.demo.dto.categories.CreateCategoryDto;
import com.example.demo.dto.categories.UpdateCategoryDto;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.model.category.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public ResponseAPI<CategoryDto> createCategory(CreateCategoryDto input) {
        return null;
    }

    @Override
    public ResponseAPI<CategoryDto> getCategoryById(UUID id) {
        return null;
    }

    @Override
    public ResponseAPI<CategoryDto> updateCategory(UUID id, UpdateCategoryDto input) {
        return null;
    }

    @Override
    public ResponseAPI<Boolean> deleteCategory(UUID id) {
        return null;
    }

    @Override
    public ResponseAPI<List<CategoryDto>> getAllCategory() {
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        List<Category> categoryList = categoryRepository.findAll();
        for (Category category : categoryList) {
            categoryDtoList.add(CategoryMapper.toCategoryDto(category));
        }
        return ResponseAPI.successResponse(categoryDtoList);
    }
}
