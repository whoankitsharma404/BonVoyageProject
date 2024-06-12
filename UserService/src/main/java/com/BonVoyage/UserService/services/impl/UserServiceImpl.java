package com.BonVoyage.UserService.services.impl;

import com.BonVoyage.UserService.models.User;
import com.BonVoyage.UserService.payloads.LoginRequest;
import com.BonVoyage.UserService.payloads.LoginResponse;
import com.BonVoyage.UserService.payloads.UserDTO;
import com.BonVoyage.UserService.repositories.UserRepository;
import com.BonVoyage.UserService.services.UserService;
import com.BonVoyage.UserService.utils.EncryptionUtils;
import com.BonVoyage.UserService.utils.Mapper;
import io.micrometer.common.util.StringUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDTO registerNewAccount(UserDTO userDTO) throws Exception {
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
        newUser.setUserPassword(EncryptionUtils.encrypt(userDTO.getUserPassword()));
        newUser.setUserAddress(userDTO.getUserAddress());
        newUser.setUserRole(userDTO.getUserRole());
        newUser.setCreatedAt(String.valueOf(new Date()));
        newUser.setUpdatedAt(String.valueOf(new Date()));
        newUser.setVersion(0);

        User muser =userRepository.save(newUser);
        return Mapper.mapToUserDto(muser);
    }

    @Override
    public LoginResponse loginUser(LoginRequest userDTO) throws Exception {
        if(StringUtils.isBlank(userDTO.getUserEmail()) || StringUtils.isBlank(userDTO.getUserPassword())){
            throw new Exception("Enter valid email and password!!");
        }
        User fetchedUser = userRepository.findByUserEmail(userDTO.getUserEmail()).orElse(null);
        assert fetchedUser != null;
        if(Boolean.TRUE.equals(validatingUserNameAndPassword(fetchedUser,userDTO.getUserPassword()))){
             LoginResponse response = new LoginResponse();
             response.setUserID(fetchedUser.getUserID());
             response.setUserRole(fetchedUser.getUserRole());
             response.setUserAddress(fetchedUser.getUserAddress());
             response.setUserPhone(fetchedUser.getUserPhone());
             response.setUserName(fetchedUser.getUserName());
             response.setUserEmail(fetchedUser.getUserEmail());
             return response;
        }
        throw new Exception("Enter valid email and password!!");
    }

    private Boolean validatingUserNameAndPassword(User fetchedUser, String userPassword) throws Exception {
        String fetchedPassword = EncryptionUtils.decrypt(fetchedUser.getUserPassword());
        return userPassword.equals(fetchedPassword);
    }


    @Override
    public UserDTO getUserByUserName(String userName) {
        User user =userRepository.findByUserName(userName).orElse(null);
        return Mapper.mapToUserDto(user);
    }

    @Override
    public UserDTO updateWishList(String userId, String packageId) {
        return null;
    }

    @Override
    public UserDTO deletePackageFromWishList(String userId, String packageId) {
        return null;
    }

    @Override
    public UserDTO getAdminDetails() {
        return userRepository.findByUserRole("ADMIN");
    }

}
