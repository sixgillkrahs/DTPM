package com.example.demo.service;

import com.example.demo.common.dto.ResponseAPI;
import com.example.demo.dto.auth.CreateAuthDto;

public interface AuthService {
    public ResponseAPI<Boolean> createUser(CreateAuthDto input);
    public ResponseAPI<String> login(String userName);
}
