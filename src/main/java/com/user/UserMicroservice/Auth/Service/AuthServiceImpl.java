package com.user.UserMicroservice.Auth.Service;

import com.user.UserMicroservice.Auth.Repository.AuthRepository;
import com.user.UserMicroservice.User.DTO.AddUSerDTO;
import com.user.UserMicroservice.User.DTO.UserInfoDTO;
import com.user.UserMicroservice.User.Entity.UserEntity;
import com.user.UserMicroservice.User.Repository.UserRepsitory;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthRepository authRepository;
    private final UserRepsitory userRepsitory;
    private final ModelMapper modelMapper;

@Override
    public UserInfoDTO registerUser(AddUSerDTO addUSerDTO){
   // UserEntity user =modelMapper.map(addUSerDTO,UserEntity.class);
    UserEntity user = modelMapper.map(addUSerDTO,UserEntity.class);
    UserEntity savedUser = userRepsitory.save(user);
    if(savedUser == null) throw  new RuntimeException("Something went wrong");
    return  modelMapper.map(savedUser,UserInfoDTO.class);
}
@Override
    public List<UserInfoDTO> getAll(){
    List<UserEntity> info =  userRepsitory.findAll();
    return  info.stream().map(i -> modelMapper.map(i,UserInfoDTO.class)).toList();
}


}
