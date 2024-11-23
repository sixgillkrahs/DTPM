package com.example.demo.dto.auths;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthDto {
    private UUID id;
    private String email;
    private UUID userId;
    private String password;
    private Boolean isDeleted;
    private Boolean isActive;
    private Date lockUntil;
    private Date createdAt;
    private Date lastUpdatedAt;
    private String lastUpdatedPassword;
}
