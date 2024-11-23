package com.example.demo.controller;

import com.example.demo.common.dto.ResponseAPI;
import com.example.demo.dto.user.CreateUserDto;
import com.example.demo.dto.user.UserDto;
import com.example.demo.service.JwtService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtService jwtService;

    @PostMapping("/create-user")
    public ResponseAPI<UserDto> createUser(@Validated @RequestBody CreateUserDto input,@RequestHeader("Authorization") String token) {
        if(token != null && token.startsWith("Bearer")) {
            token = token.substring(7);
        }
        jwtService.validateToken(token);
        return userService.createUser(input);
    }

    @GetMapping("/get-user/{id}")
    public ResponseAPI<UserDto> getUserById(@PathVariable String id, @RequestHeader("Authorization") String token) {
        return userService.getUserById(UUID.fromString(id));
    }
}
