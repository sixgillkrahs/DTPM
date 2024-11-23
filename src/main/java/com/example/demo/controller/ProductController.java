package com.example.demo.controller;

import com.example.demo.common.dto.ResponseAPI;
import com.example.demo.dto.products.CreateProductDto;
import com.example.demo.dto.products.ProductDto;
import com.example.demo.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/")
    public ResponseAPI<List<ProductDto>> getAllProduct() {
         return productService.getAllProduct();
    }

    @PostMapping("/create-product")
    public ResponseAPI<ProductDto> createProduct(CreateProductDto input) {
        return productService.createProduct(input);
    }
}
