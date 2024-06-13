package com.BonVoyage.UsersWishListService.service.impl;

import com.BonVoyage.UsersWishListService.models.UsersWishList;
import com.BonVoyage.UsersWishListService.repository.UsersWishListRepository;
import com.BonVoyage.UsersWishListService.service.UsersWishlistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersWishListServiceImpl implements UsersWishlistService {

    private UsersWishListRepository usersWishListRepository;

    @Override
    public UsersWishList postWishList(String userID, String packageID) {
        return UsersWishList.builder()
                .userID(userID)
                .packageID(packageID)
                .build();
    }
}
