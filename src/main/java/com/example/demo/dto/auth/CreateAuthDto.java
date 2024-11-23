package com.example.demo.dto.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAuthDto {
    @NotBlank(message = "Full name is required")
    private String fullName;
    @NotBlank(message = "Password is required")
    private String password;
    private String avatar = "avatar.png";
    @NotNull(message = "Date of birth is required")
    private Date dob;
    private String phone;
    private String phonePrefix = "+84";
    @NotBlank(message = "Email is required")
    private String email;
    @NotBlank
    private String gender;
    private String address;
    private String searchInfo;
}
