package com.BonVoyage.PackageItenaryService.controllers;

import com.BonVoyage.PackageItenaryService.models.PackageItenary;
import com.BonVoyage.PackageItenaryService.payload.PackageItenaryDto;
import com.BonVoyage.PackageItenaryService.services.PackageItenaryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class PackageItenaryController {

    private PackageItenaryService packageItenaryService;

    @GetMapping("/package/{packageID}")
    List<PackageItenaryDto> getPackageItenary(@PathVariable(name = "packageID") String packageID){
     return packageItenaryService.getAllPackageItenary(packageID);
    }

}
