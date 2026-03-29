package com.user.UserMicroservice.Auth.Repository;

import com.user.UserMicroservice.Auth.Entity.Auth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Auth,Long>{

    Auth findUserById(Long id);
  //  UserEntity registerUser (AddUSerDTO addUSerDTO);
//    String LogInUser(LoginUserDTO loginUserDTO);


}
