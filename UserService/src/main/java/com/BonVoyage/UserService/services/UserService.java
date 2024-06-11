package com.BonVoyage.UserService.services;

import com.BonVoyage.UserService.payloads.UserDTO;

public interface UserService {

    UserDTO registerNewAccount(UserDTO userDTO);

    UserDTO loginUser(UserDTO userDTO);

    UserDTO getUserByUserName(String userName);

    UserDTO updateWishList(String userId, String packageId);

    UserDTO deletePackageFromWishList(String userId, String packageId);

}
