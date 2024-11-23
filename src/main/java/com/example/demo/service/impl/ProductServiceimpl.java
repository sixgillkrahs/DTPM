package com.example.demo.service.impl;

import com.example.demo.common.dto.ResponseAPI;
import com.example.demo.dto.products.CreateProductDto;
import com.example.demo.dto.products.ProductDto;
import com.example.demo.mapper.ProductMapper;
import com.example.demo.model.product.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class ProductServiceimpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceimpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }





    @Override
    public ResponseAPI<List<ProductDto>> getAllProduct() {
        List<Product> productList = productRepository.findAll();
        List<ProductDto> productDtoList = new ArrayList<>();
        for (Product product : productList) {
            productDtoList.add(ProductMapper.toProductDto(product));
        }
        return null;
    }

    @Override
    public ResponseAPI<ProductDto> getProductById(String id) {
        return null;
    }

    @Override
    public ResponseAPI<ProductDto> createProduct(CreateProductDto input) {
        Product product = ProductMapper.toProduct(input);
        productRepository.save(product);
        return ResponseAPI.successResponse(ProductMapper.toProductDto(product));
    }
}
