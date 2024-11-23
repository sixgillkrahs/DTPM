package com.example.demo.model.product;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
@Builder
public class Product {
    @Id
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
