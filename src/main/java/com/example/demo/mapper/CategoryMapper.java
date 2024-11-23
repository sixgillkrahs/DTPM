package com.example.demo.mapper;

import com.example.demo.dto.categories.CategoryDto;
import com.example.demo.dto.categories.CreateCategoryDto;
import com.example.demo.dto.categories.UpdateCategoryDto;
import com.example.demo.model.category.Category;

public class CategoryMapper {
    public static CategoryDto toCategoryDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getImage(),
                category.getIsActive(),
                category.getIsDeleted(),
                category.getCreatedBy(),
                category.getUpdatedBy(),
                category.getIcon(),
                category.getParentId(),
                category.getLevel(),
                category.getOrder(),
                category.getPath()
        );
    }

    public static Category toCategory(CreateCategoryDto input) {
        return new Category(
                input.getName(),
                input.getDescription(),
                input.getImage(),
                input.getIcon(),
                input.getParentId(),
                input.getLevel(),
                input.getOrder(),
                input.getPath()
        );
    }

}
