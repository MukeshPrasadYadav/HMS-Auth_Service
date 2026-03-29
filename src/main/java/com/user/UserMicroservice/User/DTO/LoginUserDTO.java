package com.user.UserMicroservice.User.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoginUserDTO {
    @Email
    @NotBlank(message = "Enter email")
    private String Email;

    @NotBlank(message = "Enter Password")
    private String Password;
}
