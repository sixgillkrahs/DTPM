package com.example.demo.dto.categories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {
    private UUID id;
    private String name;
    private String description;
    private String image;
    private Boolean isActive;
    private Boolean isDeleted;
    private UUID createdBy;
    private UUID updatedBy;
    private String icon;
    private UUID parentId;
    private int level;
    private int order;
    private String path;
}
