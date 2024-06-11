package com.BonVoyage.PackageService.services.impl;

import com.BonVoyage.PackageService.payloads.PackageDTO;
import com.BonVoyage.PackageService.repositories.PackageRepository;
import com.BonVoyage.PackageService.services.PackageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PackageServiceImpl implements PackageService {

    private PackageRepository packageRepository;


    @Override
    public List<PackageDTO> getAllPackages() {
        return null;
    }

    @Override
    public List<PackageDTO> getPackagesByDestination(String destination) {
        return null;
    }

    @Override
    public PackageDTO getPackageById(String packageId) {
        return null;
    }

    @Override
    public PackageDTO getWishListById(String userId) {
        return null;
    }
}
