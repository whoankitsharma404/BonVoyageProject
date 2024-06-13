package com.BonVoyage.PackageItenaryService.services;

import com.BonVoyage.PackageItenaryService.models.PackageItenary;
import com.BonVoyage.PackageItenaryService.payload.PackageItenaryDto;

import java.util.List;

public interface PackageItenaryService {

    List<PackageItenaryDto> getAllPackageItenary(String packageId);
}
