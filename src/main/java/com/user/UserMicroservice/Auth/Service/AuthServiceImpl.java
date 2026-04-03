package com.user.UserMicroservice.Auth.Service;

import com.user.UserMicroservice.Auth.Repository.AuthRepository;
import com.user.UserMicroservice.User.DTO.AddUSerDTO;
import com.user.UserMicroservice.User.DTO.LoginUserDTO;
import com.user.UserMicroservice.User.DTO.UserInfoDTO;
import com.user.UserMicroservice.User.Entity.UserEntity;
import com.user.UserMicroservice.User.Repository.UserRepsitory;
import com.user.UserMicroservice.Utils.AuthUtils;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthRepository authRepository;
    private final UserRepsitory userRepsitory;
    private  final  AuthenticationManager authenticationManager;
    private final ModelMapper modelMapper;
    private  final AuthUtils authUtils;
    private  final PasswordEncoder passwordEncoder;

@Override
    public UserInfoDTO registerUser(AddUSerDTO addUSerDTO){
   // UserEntity user =modelMapper.map(addUSerDTO,UserEntity.class);
    if(userRepsitory.existsByEmail(addUSerDTO.getEmail()))
        throw  new RuntimeException("User already exists");

    UserEntity user = modelMapper.map(addUSerDTO,UserEntity.class);
    user.setPassword(passwordEncoder.encode(addUSerDTO.getPassword()));
    UserEntity savedUser = userRepsitory.save(user);
    if(savedUser == null) throw  new RuntimeException("Something went wrong");
    return  modelMapper.map(savedUser,UserInfoDTO.class);
}

@Override
public  String loginUser(LoginUserDTO loginUserDTO){
    Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(loginUserDTO.getEmail(),loginUserDTO.getPassword())
    );
    UserDetails userDetails = (UserDetails) authentication.getPrincipal();
    UserEntity user =userRepsitory.findByEmail(userDetails.getUsername());
    String token = authUtils.generateAccessToken(user);

    return token ;
}
@Override
    public List<UserInfoDTO> getAll(){
    List<UserEntity> info =  userRepsitory.findAll();
    return  info.stream().map(i -> modelMapper.map(i,UserInfoDTO.class)).toList();
}


}
