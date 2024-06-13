package com.BonVoyage.UserService.controllers;

import com.BonVoyage.UserService.payloads.*;
import com.BonVoyage.UserService.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
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
        UserDTO registeredUser =null;
        try{
            registeredUser = userService.registerNewAccount(userDTO);
            return new ResponseEntity<>(new ApiResponse(registeredUser,"success",1),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(registeredUser,"failed",0),HttpStatus.OK);
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest userDTO, HttpServletRequest request) throws Exception{
        LoginResponse response =null;
        try{
            response = userService.loginUser(userDTO,request);
            return new ResponseEntity<>(new ApiResponse(response,"success",1),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(response,"failed",0),HttpStatus.OK);
        }
    }

    @GetMapping("/user/{userName}")
    public ResponseEntity<?> getUserByName(@PathVariable String userName){
        UserDTO user =null;
        try{
            user = userService.getUserByUserName(userName);
            return new ResponseEntity<>(new ApiResponse(user,"success",1),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(user,"failed",0),HttpStatus.OK);
        }
    }

    @PutMapping("/wishlist/{userId}/{packageId}")
    public ResponseEntity<?> updateUserWishList(@PathVariable String userId,@PathVariable String packageId){
        UserDTO user =null;
        try{
            user =this.userService.updateWishList(userId,packageId);
            return new ResponseEntity<>(new ApiResponse(user,"success",1),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(user,"failed",0),HttpStatus.OK);
        }
    }

    @DeleteMapping("/wishlist/{userId}/{packageId}")
    public ResponseEntity<?> deletePackageFromWishlist(@PathVariable String userId,@PathVariable String packageId){
        return new ResponseEntity<>(this.userService.deletePackageFromWishList(userId,packageId), HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<?> adminDetailsWithBookings(){
        return new ResponseEntity<>(this.userService.getAdminDetails(), HttpStatus.OK);
    }

    @PostMapping("/createNewPackage")
    public ResponseEntity<?> addNewPackage(@RequestBody PackageDTO packageDTO){
        UserDTO user =null;
        try{
            user =this.userService.createPackage(packageDTO);
            return new ResponseEntity<>(new ApiResponse(user,"success",1),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(user,"failed",0),HttpStatus.OK);
        }
    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request) {
        try{
            this.userService.logout(request);
            return new ResponseEntity<>(new ApiResponse("logged out successfully","success",1),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse("something went wrong!!","failed",0),HttpStatus.OK);
        }


    }

}
