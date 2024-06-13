package com.BonVoyage.UserService.repositories;

import com.BonVoyage.UserService.models.UsersWishList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UsersWishListRepository extends JpaRepository<UsersWishList,String> {
    @Query("SELECT MAX(u.wishlistID) FROM UsersWishList u")
    String findMaxUserWishListId();

}
