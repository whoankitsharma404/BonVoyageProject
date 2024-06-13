package com.BonVoyage.UserService.services;

import com.BonVoyage.UserService.models.UsersWishList;
import com.BonVoyage.UserService.payloads.LoginRequest;
import com.BonVoyage.UserService.payloads.LoginResponse;
import com.BonVoyage.UserService.payloads.PackageDTO;
import com.BonVoyage.UserService.payloads.UserDTO;
import jakarta.servlet.http.HttpServletRequest;

public interface UserService {

    UserDTO registerNewAccount(UserDTO userDTO) throws Exception;

    LoginResponse loginUser(LoginRequest userDTO, HttpServletRequest request) throws Exception;

    UserDTO getUserByUserName(String userName);

    UserDTO updateWishList(String userId, String packageId);

    UserDTO deletePackageFromWishList(String userId, String packageId);

    UserDTO getAdminDetails();

    Object createPackage(PackageDTO packageDTO);

    void logout(HttpServletRequest request);

    UsersWishList addingWishList(String userID, String packageID);
}
