package com.example.demo.controller;

import com.example.demo.common.dto.ResponseAPI;
import com.example.demo.dto.auth.CreateAuthDto;
import com.example.demo.dto.auth.login.ReqLogin;
import com.example.demo.exception.ErrorCode;
import com.example.demo.service.AuthService;
import com.example.demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseAPI<Boolean> addNewUser(@Validated @RequestBody CreateAuthDto input) {
        return authService.createUser(input);
    }

    @PostMapping("/login")
    public ResponseAPI <String> login(@Validated @RequestBody ReqLogin input) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(input.getEmail(), input.getPassword()));
            return authService.login(input.getEmail());
        }catch (Exception e){
            return ResponseAPI.errorResponse(ErrorCode.FORBIDDEN);
        }
    }
}
