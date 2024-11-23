package com.example.demo.dto.categories;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryDto {
    private String name;
    private String description;
    private String image;
    private Boolean isActive;
    private Boolean isDeleted;
    private String icon;
    private String parentId;
    private int level;
    private int order;
    private String path;
}
