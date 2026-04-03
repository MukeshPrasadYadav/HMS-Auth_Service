package com.user.UserMicroservice.Auth.Controller;

import com.user.UserMicroservice.Auth.Service.AuthService;
import com.user.UserMicroservice.User.DTO.AddUSerDTO;
import com.user.UserMicroservice.User.DTO.LoginUserDTO;
import com.user.UserMicroservice.User.DTO.UserInfoDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

   // private  final AuthService authService;
    private final AuthService authService;

    @PostMapping("/register")
    public UserInfoDTO registerUser(@RequestBody AddUSerDTO addUSerDTO){
        return  authService.registerUser(addUSerDTO);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginUserDTO loginUserDTO){
        return  authService.loginUser(loginUserDTO);
    }

    @GetMapping("/All")
    public List<UserInfoDTO> getAllUser(){
        return  authService.getAll();
    }



}
