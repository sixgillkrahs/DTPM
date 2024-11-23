package com.example.demo.service.impl;

import com.example.demo.common.dto.ResponseAPI;
import com.example.demo.exception.ErrorCode;
import com.example.demo.service.JwtService;
import com.example.demo.utils.JwtUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtServiceImpl implements JwtService {
    @Value("${resources.resource.static.locations}")
    private String localPath;
    private String privateKeyPath = "private.pem";
    private String publicKeyPath = "public.pem";

    @Override
    public boolean validateToken(String token) {
        try {
            PublicKey publicKey = JwtUtil.getPublicKey(localPath + publicKeyPath);
            Jwts.parserBuilder()
                    .setSigningKey(publicKey)
                    .build()
                    .parseClaimsJws(token);
            return true; // Token hợp lệ
        } catch (Exception e) {
            return false; // Token không hợp lệ
        }
    }

    @Override
    public ResponseAPI<String> generateToken(String userName) {
        try {
            Map<String, Object> claims = new HashMap<>();
            return ResponseAPI.successResponse(createToken(claims, userName));
        }catch (Exception e){
            return ResponseAPI.errorResponse(ErrorCode.FAILED);
        }
    }

    @Override
    public String extractUsername(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(JwtUtil.getPublicKey(localPath + publicKeyPath))
                    .build()
                    .parseClaimsJws(token)
                    .getBody()
                    .getSubject();
        } catch (Exception e) {
            return null;
        }
    }

    private String createToken(Map<String, Object> claims, String userName ) throws Exception {
        PrivateKey privateKey = JwtUtil.getPrivateKey(localPath + privateKeyPath);
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30))
                .signWith(privateKey, SignatureAlgorithm.RS256).compact();
    }
}
