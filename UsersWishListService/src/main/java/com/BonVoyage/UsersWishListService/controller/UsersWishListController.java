package com.BonVoyage.UsersWishListService.controller;

import com.BonVoyage.UserService.payloads.ApiResponse;
import com.BonVoyage.UserService.payloads.UserDTO;
import com.BonVoyage.UsersWishListService.models.UsersWishList;
import com.BonVoyage.UsersWishListService.service.UsersWishlistService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UsersWishListController {

    private UsersWishlistService usersWishlistService;

    @PostMapping("/wishlist/{userID}/{packageID}")
    public ResponseEntity<UsersWishList> addWishList(@PathVariable String userID,@PathVariable String packageID ){
        UsersWishList registeredUser =null;
        try{
            registeredUser = usersWishlistService.postWishList(userID,packageID);
            return new ResponseEntity<>(registeredUser, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(registeredUser,HttpStatus.BAD_REQUEST);
        }
    }

}
