package com.BonVoyage.UserService.repositories;

import com.BonVoyage.UserService.models.UsersWishList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersWishListRepository extends JpaRepository<UsersWishList,String> {
}
