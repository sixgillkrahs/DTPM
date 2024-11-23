package com.example.demo.controller;

import com.example.demo.common.dto.ResponseAPI;
import com.example.demo.dto.categories.CategoryDto;
import com.example.demo.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping("getCategories")
    public ResponseAPI<List<CategoryDto>> getAllCategory() {
        return categoryService.getAllCategory();
    }
}
