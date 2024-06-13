package com.BonVoyage.UsersWishListService.repository;

import com.BonVoyage.UsersWishListService.models.UsersWishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersWishListRepository extends JpaRepository<UsersWishList,String> {
}
