package com.example.demo.service.impl;

import com.example.demo.common.dto.ResponseAPI;
import com.example.demo.dto.auths.CreateAuthDto;
import com.example.demo.dto.users.CreateUserDto;
import com.example.demo.dto.users.UserDto;
import com.example.demo.exception.ErrorCode;
import com.example.demo.mapper.AuthMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.auth.Auth;
import com.example.demo.repository.AuthRepository;
import com.example.demo.service.AuthService;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private AuthRepository repository;
    @Autowired
    private UserService userService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;


    @Override
    public ResponseAPI<Boolean> createUser(CreateAuthDto input) {
        Auth auth = AuthMapper.toUserAuth(input);
        auth.setPassword(passwordEncoder.encode(input.getPassword()));
        CreateUserDto createUserDto = CreateUserDto.builder()
                .dob(input.getDob())
                .email(input.getEmail())
                .fullName(input.getFullName())
                .createdAt(new Date())
                .avatar(input.getAvatar())
                .phone(input.getPhone())
                .phonePrefix(input.getPhonePrefix())
                .gender(input.getGender())
                .address(input.getAddress())
                .searchInfo(input.getSearchInfo())
                .build();
        ResponseAPI<UserDto> resp = userService.createUser(createUserDto);
        if(resp.getData() == null){
            return ResponseAPI.errorResponse(ErrorCode.ITEM_NOT_FOUND);
        }
        auth.setUserid(UserMapper.toUser(resp.getData()));
        repository.save(auth);
        return ResponseAPI.successResponse(true);
    }

    @Override
    public ResponseAPI<String> login(String userName) {
        return jwtService.generateToken(userName);
    }
}
