package com.BonVoyage.PackageService.utils;


import com.BonVoyage.PackageService.PackageServiceApplication;
import com.BonVoyage.PackageService.payloads.PackageDTO;

public class Mapper {

    public static PackageDTO mapToPackageDto(Package packages) {
        return PackageServiceApplication.modelMapper().map(packages, PackageDTO.class);
    }

    public static Package mapToPackageEntity(PackageDTO packageDTO) {
        return PackageServiceApplication.modelMapper().map(packageDTO, Package.class);
    }
}
