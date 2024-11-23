package com.example.demo.mapper;

import com.example.demo.dto.products.CreateProductDto;
import com.example.demo.dto.products.ProductDto;
import com.example.demo.model.product.Product;

public class ProductMapper {
    public static ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setSku(product.getSku());
        productDto.setSlug(product.getSlug());
        productDto.setCode(product.getCode());
        productDto.setDescription(product.getDescription());
        productDto.setPrice(product.getPrice());
        productDto.setVisible(product.getVisible());
        productDto.setIsDeleted(product.getIsDeleted());
        productDto.setImage(product.getImage());
        productDto.setCategoryId(product.getCategoryId());
        productDto.setStock(product.getStock());
        productDto.setAttributes(product.getAttributes());
        return productDto;
    }

    public static Product toProduct(CreateProductDto input) {
        return Product.builder()
                .name(input.getName())
                .price(input.getPrice())
                .visible(input.getVisible())
                .isDeleted(false)
                .image(input.getImage())
                .categoryId(input.getCategoryId())
                .stock(input.getStock())
                .attributes(input.getAttributes())
                .slug(input.getSlug())
                .code(input.getCode())
                .sku(input.getSku())
                .build();
    }
}
