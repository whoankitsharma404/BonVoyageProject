package com.BonVoyage.PackageService.utils;


import com.BonVoyage.PackageService.PackageServiceApplication;
import com.BonVoyage.PackageService.payloads.PackageDTO;

public class Mapper {

    public static PackageDTO mapToUserDto(Package user) {
        return PackageServiceApplication.modelMapper().map(user, PackageDTO.class);
    }

    public static Package mapToUserEntity(PackageDTO packageDTO) {
        return PackageServiceApplication.modelMapper().map(packageDTO, Package.class);
    }
}
