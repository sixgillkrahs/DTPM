package com.example.demo.service;

import com.example.demo.common.dto.ResponseAPI;
import com.example.demo.dto.products.CreateProductDto;
import com.example.demo.dto.products.ProductDto;

import java.util.List;

public interface ProductService {
    ResponseAPI<List<ProductDto>> getAllProduct();
    ResponseAPI<ProductDto> getProductById(String id);
    ResponseAPI<ProductDto> createProduct(CreateProductDto input);
}
