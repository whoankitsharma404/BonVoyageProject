package com.BonVoyage.UserService.services.impl;

import com.BonVoyage.UserService.models.User;
import com.BonVoyage.UserService.payloads.UserDTO;
import com.BonVoyage.UserService.repositories.UserRepository;
import com.BonVoyage.UserService.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDTO registerNewAccount(UserDTO userDTO) {

        String email = userDTO.getUserEmail();

        User user =userRepository.findByUserEmail(email).orElse(null);

        if (user!=null) {
            throw new RuntimeException("User already exists");
        }

        User newUser = new User();
        newUser.setUserID(UUID.randomUUID().toString());
        newUser.setUserName(userDTO.getUserName());
        newUser.setUserEmail(userDTO.getUserEmail());
        newUser.setUserPhone(userDTO.getUserPhone());
        newUser.setUserPassword(userDTO.getUserPassword());
        newUser.setUserAddress(userDTO.getUserAddress());
        newUser.setUserRole(userDTO.getUserRole());
        newUser.setCreatedDate(String.valueOf(new Date()));
        newUser.setUpdatedDate(String.valueOf(new Date()));
        newUser.setVersion(0);

        userRepository.save(newUser);

        userDTO.setUserPassword(null);
        return userDTO;
    }

    @Override
    public UserDTO loginUser(UserDTO userDTO) {
       return null;
    }

    @Override
    public UserDTO getUserByUserName(String userName) {
        return null;
    }

    @Override
    public UserDTO updateWishList(String userId, String packageId) {
        return null;
    }

    @Override
    public UserDTO deletePackageFromWishList(String userId, String packageId) {
        return null;
    }

}
