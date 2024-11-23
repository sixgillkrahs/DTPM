package com.example.demo.service.impl;

import com.example.demo.common.dto.ResponseAPI;
import com.example.demo.dto.user.CreateUserDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.exception.ErrorCode;
import com.example.demo.exception.HandleRuntimeException;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.user.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;


    @Override
    public ResponseAPI<UserDto> createUser(CreateUserDto input) {
        if(repository.findByEmail(input.getEmail()) != null){
            throw new HandleRuntimeException(ErrorCode.USER_ALREADY_EXISTS);
        }
        if(repository.findByPhone(input.getPhone()) != null){
            throw new HandleRuntimeException(ErrorCode.USER_ALREADY_EXISTS);
        }
            try {
                User user = UserMapper.toUser(input);
                User savedUser = repository.save(user);
                return ResponseAPI.successResponse(UserMapper.toUserDto(savedUser));
            }
            catch (Exception e){
                return ResponseAPI.errorResponse(ErrorCode.FAILED);
            }
    }

    @Override
    public ResponseAPI<UserDto> getUserById(UUID id) {
        User user = repository.findById(id).orElse(null);
        if(user != null){
            return ResponseAPI.successResponse(UserMapper.toUserDto(user));
        }
        return null;
    }
}
