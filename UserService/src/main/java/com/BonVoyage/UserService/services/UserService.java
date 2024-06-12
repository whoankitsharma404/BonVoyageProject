package com.BonVoyage.UserService.services;

import com.BonVoyage.UserService.payloads.LoginRequest;
import com.BonVoyage.UserService.payloads.LoginResponse;
import com.BonVoyage.UserService.payloads.UserDTO;

public interface UserService {

    UserDTO registerNewAccount(UserDTO userDTO) throws Exception;

    LoginResponse loginUser(LoginRequest userDTO) throws Exception;

    UserDTO getUserByUserName(String userName);

    UserDTO updateWishList(String userId, String packageId);

    UserDTO deletePackageFromWishList(String userId, String packageId);

    UserDTO getAdminDetails();
}
