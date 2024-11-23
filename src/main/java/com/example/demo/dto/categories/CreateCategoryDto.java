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
public class CreateCategoryDto {
    private String name;
    private String description;
    private String image;
    private String icon;
    private UUID parentId;
    private int level;
    private int order;
    private String path;
}
