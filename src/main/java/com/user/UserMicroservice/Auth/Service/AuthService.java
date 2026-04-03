package com.user.UserMicroservice.Auth.Service;

import com.user.UserMicroservice.User.DTO.AddUSerDTO;
import com.user.UserMicroservice.User.DTO.LoginUserDTO;
import com.user.UserMicroservice.User.DTO.UserInfoDTO;

import java.util.List;

public interface AuthService {

    String loginUser(LoginUserDTO loginUserDTO);
    UserInfoDTO registerUser(AddUSerDTO addUSerDTO);
    List<UserInfoDTO> getAll();

}
