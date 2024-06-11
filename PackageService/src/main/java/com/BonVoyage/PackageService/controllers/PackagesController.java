package com.BonVoyage.PackageService.controllers;

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
    public ResponseEntity<List<PackageDTO>> getAllPackage(){
        return new ResponseEntity<>(this.packageService.getAllPackages(), HttpStatus.OK);
    }

    @GetMapping("/getPackages/{destination}")
    public ResponseEntity<List<PackageDTO>> getAllPackage(@PathVariable String destination){
        return new ResponseEntity<>(this.packageService.getPackagesByDestination(destination), HttpStatus.OK);
    }

    @GetMapping("/onepackage/{packageId}")
    public ResponseEntity<PackageDTO> getPackageById(@PathVariable String packageId){
        return new ResponseEntity<>(this.packageService.getPackageById(packageId), HttpStatus.OK);
    }


    @GetMapping("/wishlist/{userId}")
    public ResponseEntity<PackageDTO> getWishListById(@PathVariable String userId){
        return new ResponseEntity<>(this.packageService.getWishListById(userId), HttpStatus.OK);
    }

}
