package com.example.demo.dto.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUserDto {
    @NotBlank(message = "fullName must no blank")
    private String fullName;
    private String avatar = "avatar.png";
    @NotNull(message = "Date of birth must not be null")
    private Date dob;
    private String phone;
    private String phonePrefix = "+84";
    @NotBlank(message = "email must no blank")
    private String email;
    @NotBlank
    private String gender;
    @NotBlank(message = "address must no blank")
    private String address;
    private Boolean isDeleted = false;
    private Boolean isActive = true;
    private String searchInfo;
    private Date createdAt = new Date();
    private String createdBy = "admin";
    private Date lastUpdatedAt =new Date();
    private String lastUpdatedBy = "admin";
}
