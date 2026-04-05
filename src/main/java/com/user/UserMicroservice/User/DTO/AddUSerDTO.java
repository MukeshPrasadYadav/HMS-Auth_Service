package com.user.UserMicroservice.User.DTO;

import com.user.UserMicroservice.User.Enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AddUSerDTO {


    @NotBlank(message = "Provide email")
    private String email;

    @NotBlank(message = "Enter password")
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;
}
