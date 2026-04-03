package com.user.UserMicroservice.CustomizedUserDetails;

import com.user.UserMicroservice.User.Entity.UserEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


public class CustomizedUserDetails implements UserDetails {
    private  final UserEntity user;

    public  CustomizedUserDetails(UserEntity user){
        this.user = user;
    }
    @Override
    public String getUsername(){
        String userName = user.getEmail();
        return  userName;
    }
    @Override

    public String getPassword(){
        return  user.getPassword();
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return  List.of(new SimpleGrantedAuthority("ROLE_"+user.getRole().name()));
    }
}
