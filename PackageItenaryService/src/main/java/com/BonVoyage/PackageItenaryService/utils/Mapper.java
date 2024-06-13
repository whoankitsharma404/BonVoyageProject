package com.BonVoyage.PackageItenaryService.utils;

import com.BonVoyage.PackageItenaryService.PackageItenaryServiceApplication;
import com.BonVoyage.PackageItenaryService.models.PackageItenary;
import com.BonVoyage.PackageItenaryService.payload.PackageItenaryDto;
import com.BonVoyage.PackageItenaryService.repository.PackageItenaryRepository;

public class Mapper {

    public static PackageItenaryDto mapToPackageItenaryDto(PackageItenary packageItenary) {
        return PackageItenaryServiceApplication.modelMapper().map(packageItenary, PackageItenaryDto.class);
    }

    public static PackageItenary mapToUserEntity(PackageItenaryDto packageItenaryDto) {
        return PackageItenaryServiceApplication.modelMapper().map(packageItenaryDto, PackageItenary.class);
    }




}

