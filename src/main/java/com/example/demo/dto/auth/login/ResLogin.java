package com.example.demo.dto.auth.login;

import com.example.demo.dto.user.UserDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResLogin {
    private String token;
    private UserDto user;
}
