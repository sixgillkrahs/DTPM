package com.example.demo.dto.products;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private String id;
    private String name;
    private String sku;
    private String slug;
    private String code;
    private String description;
    private Double price;
    private Boolean visible;
    private Boolean isDeleted;
    private String image;
    private UUID categoryId;
    private int stock;
    private Map<String, Object> attributes;
}
