package com.BonVoyage.UsersWishListService.service;

import com.BonVoyage.UsersWishListService.models.UsersWishList;

public interface UsersWishlistService {
    UsersWishList postWishList(String userID, String packageID);
}
