package com.user.UserMicroservice.User.Entity;

import com.user.UserMicroservice.User.Enums.Gender;
import com.user.UserMicroservice.User.Enums.IdProof;
import com.user.UserMicroservice.User.Enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "UserInfo")
@AllArgsConstructor
@NoArgsConstructor

public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private  String firstName ;

    private String middleName;

    @Column(nullable = false)
    private  String lastName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(nullable = false)
    private Date dob;

    @Enumerated(EnumType.STRING)
    private IdProof identityProof;

    private  String phoneNumber;

    @Column(nullable = false)
    private  String email;

    @Column(nullable = false)
    private String password;

    @CreationTimestamp
    private LocalDateTime createdAt;
    @CreationTimestamp
    private  LocalDateTime updatedAt;

}
