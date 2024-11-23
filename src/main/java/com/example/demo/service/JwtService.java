package com.example.demo.service;

import com.example.demo.common.dto.ResponseAPI;

public interface JwtService {
    public boolean validateToken(final String token);
    public ResponseAPI<String> generateToken(String userName);
    public String extractUsername(String token);
}
