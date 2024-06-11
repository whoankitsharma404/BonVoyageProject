package com.BonVoyage.UserService.controllers;

import com.BonVoyage.UserService.payloads.ApiResponse;
import com.BonVoyage.UserService.payloads.UserDTO;
import com.BonVoyage.UserService.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerNewUser(@RequestBody UserDTO userDTO){
//        this.userService.registerNewAccount(userDTO);
//        return new ResponseEntity<>(new ApiResponse("failed",1), HttpStatus.OK);
        UserDTO registeredUser =null;
        try{
            registeredUser = userService.registerNewAccount(userDTO);
            return new ResponseEntity<>(new ApiResponse(registeredUser,"success",1),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(registeredUser,"failed",0),HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody UserDTO userDTO){

        return new ResponseEntity<>(this.userService.loginUser(userDTO), HttpStatus.OK);
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<?> getUserByName(@PathVariable String userName){
        return new ResponseEntity<>(this.userService.getUserByUserName(userName), HttpStatus.OK);
    }

    @PutMapping("/wishlist/{userId}/{packageId}")
    public ResponseEntity<?> updateUserWishList(@PathVariable String userId,@PathVariable String packageId){
        return new ResponseEntity<>(this.userService.updateWishList(userId,packageId), HttpStatus.OK);
    }

    @DeleteMapping("/wishlist/{userId}/{packageId}")
    public ResponseEntity<?> deletePackageFromWishlist(@PathVariable String userId,@PathVariable String packageId){
        return new ResponseEntity<>(this.userService.deletePackageFromWishList(userId,packageId), HttpStatus.OK);
    }




}
