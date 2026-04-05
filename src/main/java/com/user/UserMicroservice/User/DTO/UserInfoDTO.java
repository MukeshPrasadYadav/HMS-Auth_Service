package com.user.UserMicroservice.User.DTO;

import com.user.UserMicroservice.User.Enums.Role;
import lombok.Data;

@Data
public class UserInfoDTO {
    private long id;
    private Role role;

}
