package com.BonVoyage.UsersWishListService.utils;

import com.BonVoyage.UserService.UserServiceApplication;
import com.BonVoyage.UsersWishListService.UsersWishListServiceApplication;
import com.BonVoyage.UsersWishListService.models.UsersWishList;
import com.BonVoyage.UsersWishListService.payloads.UsersWishListDTO;

public class Mapper {

    public static UsersWishListDTO mapToUsersWishListDto(UsersWishList usersWishList) {
        return UsersWishListServiceApplication.modelMapper().map(usersWishList, UsersWishListDTO.class);
    }

    public static UsersWishList mapToUsersWishListEntity(UsersWishListDTO usersWishListDTO) {
        return UserServiceApplication.modelMapper().map(usersWishListDTO, UsersWishList.class);
    }

}

