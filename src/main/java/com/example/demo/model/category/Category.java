package com.example.demo.model.category;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
@Entity
public class Category {
    @Id
    @UuidGenerator(style = UuidGenerator.Style.RANDOM)
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
    @Column(name = "order-sort")
    private int order;
    private String path;

    public Category(String name, String description, String image, String icon, UUID parentId, int level, int order, String path) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.icon = icon;
        this.parentId = parentId;
        this.level = level;
        this.order = order;
        this.path = path;
    }
}
