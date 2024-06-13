package com.BonVoyage.UserService.repositories;

import com.BonVoyage.UserService.models.User;
import com.BonVoyage.UserService.payloads.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,String>{
    Optional<User> findByUserName(String userName);
//    @Query("SELECT u FROM User u WHERE u.userEmail = :userEmail")
//    Optional<User> findByUserEmail(@Param("userEmail") String userEmail);

    Optional<User> findByUserEmail( String userEmail);
    UserDTO findByUserRole(String admin);
    @Query("SELECT MAX(u.userID) FROM User u")
    String findMaxUserId();
}
