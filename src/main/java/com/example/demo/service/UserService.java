package com.example.demo.service;

import com.example.demo.common.dto.ResponseAPI;
import com.example.demo.dto.users.CreateUserDto;
import com.example.demo.dto.users.UserDto;

import java.util.UUID;

public interface UserService {
    public ResponseAPI<UserDto> createUser(CreateUserDto input);
    public ResponseAPI<UserDto> getUserById(UUID id);
}
