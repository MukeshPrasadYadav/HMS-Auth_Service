package com.user.UserMicroservice.User.DTO;

import com.user.UserMicroservice.User.Enums.Gender;
import com.user.UserMicroservice.User.Enums.Role;
import lombok.Data;

import java.util.Date;

@Data
public class UserInfoDTO {
    private long id;
    private String firstName;
    private String middleName;
    private  String  lastName;
    private Role role;

    private Gender gender;
    private Date dob;
}
