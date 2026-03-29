package com.user.UserMicroservice.User.DTO;

import com.user.UserMicroservice.User.Enums.Gender;
import com.user.UserMicroservice.User.Enums.IdProof;
import com.user.UserMicroservice.User.Enums.Role;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class AddUSerDTO {

    @NotBlank(message = "Enter first name")
    private  String firstName ;

    private String middleName;
    @NotBlank(message = "Enter last name")
    private  String lastName;

    @NotBlank(message = "Provide email")
    private  String email;

    @NotBlank(message = "Enter password")
    private String password;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private Role role;

    @NotNull(message = "Enter date of birth")
    private Date dob;

    @Enumerated(EnumType.STRING)
    private IdProof identityProof;

    @Size(min = 10, max =  10, message = "Enter valid phone number")
    private  String phoneNumber;
}
