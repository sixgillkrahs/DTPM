package com.example.demo.mapper;

import com.example.demo.dto.auth.AuthDto;
import com.example.demo.dto.auth.CreateAuthDto;
import com.example.demo.model.auth.Auth;

import java.util.Date;
import java.util.UUID;

public class AuthMapper {
    public static Auth toUserAuth(CreateAuthDto input) {
        Auth userAuth = new Auth();
        userAuth.setEmail(input.getEmail());
        userAuth.setPassword(input.getPassword());
        userAuth.setCreatedAt(new Date());
        userAuth.setLastUpdatedAt(new Date());
        userAuth.setIsActive(true);
        userAuth.setIsDeleted(false);
        userAuth.setLockUntil(null);
        return userAuth;
    }

    public static AuthDto toUserAuthDto(Auth auth) {
        AuthDto authDto = new AuthDto();
        authDto.setId(auth.getId());
        authDto.setEmail(auth.getEmail());
        authDto.setUserId(auth.getUserid().getId());
        authDto.setPassword(auth.getPassword());
        authDto.setIsDeleted(auth.getIsDeleted());
        authDto.setIsActive(auth.getIsActive());
        authDto.setLockUntil(auth.getLockUntil());
        authDto.setCreatedAt(auth.getCreatedAt());
        authDto.setLastUpdatedAt(auth.getLastUpdatedAt());
        authDto.setLastUpdatedPassword(auth.getLastUpdatedPassword());
        return authDto;
    }
}
