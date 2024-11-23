package com.example.demo.service;

import com.example.demo.common.dto.ResponseAPI;
import com.example.demo.dto.categories.CategoryDto;
import com.example.demo.dto.categories.CreateCategoryDto;
import com.example.demo.dto.categories.UpdateCategoryDto;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    public ResponseAPI<CategoryDto> createCategory(CreateCategoryDto input);
    public ResponseAPI<CategoryDto> getCategoryById(UUID id);
    public ResponseAPI<CategoryDto> updateCategory(UUID id, UpdateCategoryDto input);
    public ResponseAPI<Boolean> deleteCategory(UUID id);
    public ResponseAPI<List<CategoryDto>> getAllCategory();
}
