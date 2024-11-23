package com.example.demo.model.auth;

import com.example.demo.model.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "auth")
@Entity
@ToString
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String email;
    private String password;
    private Boolean isDeleted;
    private Boolean isActive;
    private Date lockUntil;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdatedAt;
    private String lastUpdatedPassword;
    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User userid;
}
