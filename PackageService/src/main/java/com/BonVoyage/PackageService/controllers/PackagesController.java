package com.BonVoyage.PackageService.controllers;

import com.BonVoyage.PackageService.payloads.ApiResponse;
import com.BonVoyage.PackageService.payloads.PackageDTO;
import com.BonVoyage.PackageService.services.PackageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PackagesController {

    private PackageService packageService;

    @GetMapping("/getPackages")
    public ResponseEntity<?> getAllPackage(){
        List<PackageDTO> packageDTOList =null;
        try{
            packageDTOList = packageService.getAllPackages();
            return new ResponseEntity<>(new ApiResponse(packageDTOList,"success",packageDTOList.size()),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(packageDTOList,"failed",0),HttpStatus.OK);
        }
    }

    @GetMapping("/getPackages/{destination}")
    public ResponseEntity<?> getAllPackage(@PathVariable String destination){

        List<PackageDTO> packageDTOList =null;
        try{
            packageDTOList = packageService.getPackagesByDestination(destination);
            return new ResponseEntity<>(new ApiResponse(packageDTOList,"success",packageDTOList.size()),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(packageDTOList,"failed",0),HttpStatus.OK);
        }
    }

    @GetMapping("/onepackage/{packageId}")
    public ResponseEntity<?> getPackageById(@PathVariable String packageId){
        PackageDTO pkg =null;
        try{
            pkg = packageService.getPackageById(packageId);
            return new ResponseEntity<>(new ApiResponse(pkg,"success",1),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(pkg,"failed",0),HttpStatus.OK);
        }
    }


    @GetMapping("/wishlist/{userId}")
    public ResponseEntity<?> getWishListById(@PathVariable String userId){
        List<PackageDTO> pkg =null;
        try{
            pkg = packageService.getWishListById(userId);
            return new ResponseEntity<>(new ApiResponse(pkg,"success",1),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(pkg,"failed",0),HttpStatus.OK);
        }
    }

}
