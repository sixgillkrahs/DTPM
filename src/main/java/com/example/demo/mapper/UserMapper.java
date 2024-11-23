package com.example.demo.mapper;

import com.example.demo.dto.user.CreateUserDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.model.user.User;

import java.util.UUID;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getFullName(),
                user.getAvatar(),
                user.getDob(),
                user.getPhone(),
                user.getPhonePrefix(),
                user.getEmail(),
                user.getGender(),
                user.getAddress(),
                user.getIsDeleted(),
                user.getIsActive(),
                user.getSearchInfo(),
                user.getCreatedAt(),
                user.getCreatedBy(),
                user.getLastUpdatedAt(),
                user.getLastUpdatedBy()
        );
    }

    public static User toUser(CreateUserDto input) {
        return new User(input.getFullName(),input.getAvatar(),input.getDob(),input.getPhone(),input.getPhonePrefix(),input.getEmail(),input.getGender(),input.getAddress(),input.getIsDeleted(),input.getIsActive(),input.getSearchInfo(),input.getCreatedAt(),input.getCreatedBy(),input.getLastUpdatedAt(),input.getLastUpdatedBy());
    }

    public static User toUser(UserDto input) {
        return new User(input.getId(),input.getFullName(),input.getAvatar(),input.getDob(),input.getPhone(),input.getPhonePrefix(),input.getEmail(),input.getGender(),input.getAddress(),input.getIsDeleted(),input.getIsActive(),input.getSearchInfo(),input.getCreatedAt(),input.getCreatedBy(),input.getLastUpdatedAt(),input.getLastUpdatedBy());
    }
}
