package com.BonVoyage.PackageService.utils;


import com.BonVoyage.PackageService.PackageServiceApplication;
import com.BonVoyage.PackageService.models.Packages;
import com.BonVoyage.PackageService.payloads.PackageDTO;

public class Mapper {

    public static PackageDTO mapToPackageDto(Packages packages) {
        return PackageServiceApplication.modelMapper().map(packages, PackageDTO.class);
    }

    public static Packages mapToPackageEntity(PackageDTO packageDTO) {
        return PackageServiceApplication.modelMapper().map(packageDTO, Packages.class);
    }
}
