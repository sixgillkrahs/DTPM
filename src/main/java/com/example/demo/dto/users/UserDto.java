package com.example.demo.dto.users;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private UUID id;
    private String fullName;
    private String avatar;
    private Date dob;
    private String phone;
    private String phonePrefix;
    private String email;
    private String gender;
    private String address;
    private Boolean isDeleted;
    private Boolean isActive;
    private String searchInfo;
    private Date createdAt;
    private String createdBy;
    private Date lastUpdatedAt;
    private String lastUpdatedBy;
}
