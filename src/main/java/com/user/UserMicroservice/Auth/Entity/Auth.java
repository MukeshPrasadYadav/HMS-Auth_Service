package com.user.UserMicroservice.Auth.Entity;

import com.user.UserMicroservice.User.Entity.UserEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Auth {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    @CreationTimestamp
    private LocalDateTime CreatedAt;
    @CreationTimestamp
    private  LocalDateTime UpdatedAt;

    private  boolean IsRevoked;

    private String RefreshToken;

    @ManyToOne
    @JoinColumn(name = "user_id",nullable = false)
    private UserEntity User;
}
