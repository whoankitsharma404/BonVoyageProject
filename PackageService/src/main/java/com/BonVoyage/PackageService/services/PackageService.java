package com.BonVoyage.PackageService.services;

import com.BonVoyage.PackageService.payloads.PackageDTO;

import java.util.List;

public interface PackageService {

    List<PackageDTO> getAllPackages();

    List<PackageDTO> getPackagesByDestination(String destination);

    PackageDTO getPackageById(String packageId);

    List<PackageDTO> getWishListById(String userId);

}
