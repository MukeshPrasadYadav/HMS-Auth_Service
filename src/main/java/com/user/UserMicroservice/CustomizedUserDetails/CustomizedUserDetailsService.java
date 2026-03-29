package com.user.UserMicroservice.CustomizedUserDetails;


import com.user.UserMicroservice.User.Entity.UserEntity;
import com.user.UserMicroservice.User.Repository.UserRepsitory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomizedUserDetailsService implements UserDetailsService {

    private final UserRepsitory userRepsitory;

    @Override
    public UserDetails loadUserByUsername (String email) throws UsernameNotFoundException {
        UserEntity user = userRepsitory.findByEmail(email);
        return  new CustomizedUserDetails(user);
    }
}
