package com.example.demo.model.user;

import com.example.demo.model.auth.Auth;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;
    @Column(name = "full_name")
    private String fullName;
    @Column(name = "avatar")
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
    @Timestamp
    private Date createdAt;
    private String createdBy;
    @Timestamp
    private Date lastUpdatedAt;
    private String lastUpdatedBy;

    public User(String fullName,  String avatar,  Date dob,  String phone,  String phonePrefix,  String email,  String gender,  String address,  Boolean isDeleted,  Boolean isActive,  String searchInfo,  Date createdAt,  String createdBy,  Date lastUpdatedAt,  String lastUpdatedBy) {
        this.fullName = fullName;
        this.avatar = avatar;
        this.dob = dob;
        this.phone = phone;
        this.phonePrefix = phonePrefix;
        this.email = email;
        this.gender = gender;
        this.address = address;
        this.isDeleted = isDeleted;
        this.isActive = isActive;
        this.searchInfo = searchInfo;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.lastUpdatedAt = lastUpdatedAt;
        this.lastUpdatedBy = lastUpdatedBy;
    }
}


