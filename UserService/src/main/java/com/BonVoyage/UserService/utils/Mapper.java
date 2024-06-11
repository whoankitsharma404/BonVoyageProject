package com.BonVoyage.UserService.utils;

import com.BonVoyage.UserService.UserServiceApplication;
import com.BonVoyage.UserService.models.User;
import com.BonVoyage.UserService.payloads.UserDTO;

public class Mapper {

    public static UserDTO mapToUserDto(User user) {
        return UserServiceApplication.modelMapper().map(user, UserDTO.class);
    }

    public static User mapToUserEntity(UserDTO userDto) {
        return UserServiceApplication.modelMapper().map(userDto, User.class);
    }




}
