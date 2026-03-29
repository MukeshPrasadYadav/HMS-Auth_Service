package com.user.UserMicroservice.User.Repository;

import com.user.UserMicroservice.User.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepsitory extends JpaRepository<UserEntity,Long> {

    UserEntity findByEmail(String email);
  //  UserEntity addUser (AddUSerDTO addUSerDTO);
}
