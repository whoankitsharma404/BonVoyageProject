package com.BonVoyage.PackageService.services.impl;

import com.BonVoyage.PackageService.external.PackageItenaryService;
import com.BonVoyage.PackageService.models.Packages;
import com.BonVoyage.PackageService.payloads.PackageDTO;
import com.BonVoyage.PackageService.payloads.PackageItenaryDto;
import com.BonVoyage.PackageService.repositories.PackageRepository;
import com.BonVoyage.PackageService.services.PackageService;
import com.BonVoyage.PackageService.utils.Mapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PackageServiceImpl implements PackageService {

    private PackageRepository packageRepository;
    private PackageItenaryService packageItenaryService;

    @Override
    public List<PackageDTO> getAllPackages() {
        List<Packages> allPackages = packageRepository.findAll();
        return allPackages.stream().map(this::mapToPackageDto).collect(Collectors.toList());
    }

    private PackageDTO mapToPackageDto(Packages pkg) {
        PackageDTO packageDTO = new PackageDTO();
        packageDTO.setPackageID(pkg.getPackageID());
        packageDTO.setPackageCountry(pkg.getPackageCountry());
        packageDTO.setPackageCity(pkg.getPackageCity());
        packageDTO.setPackageName(pkg.getPackageName());
        packageDTO.setPackageDesc(pkg.getPackageDesc());
        packageDTO.setPackageRating(pkg.getPackageRating());
        packageDTO.setPackageReviews(pkg.getPackageReviews());
        packageDTO.setPackagePrice(pkg.getPackagePrice());
        packageDTO.setPackageDuration(pkg.getPackageDuration());
        packageDTO.setMinAge(pkg.getMinAge());
        packageDTO.setMaxPeople(pkg.getMaxPeople());
        packageDTO.setPackagePickup(pkg.getPackagePickup());
        packageDTO.setAvailableDate(pkg.getAvailableDate());
        packageDTO.setPackageLanguage(pkg.getPackageLanguage());
        packageDTO.setPackageImage(pkg.getPackageImage());
        packageDTO.setCreatedDate(pkg.getCreatedDate());
        packageDTO.setUpdatedDate(pkg.getUpdatedDate());


        List<PackageItenaryDto> all =packageItenaryService.getPackageItenary(pkg.getPackageID());

        packageDTO.setPackageItenary(all);
        return packageDTO;
    }


    @Override
    public List<PackageDTO> getPackagesByDestination(String destination) {

        List<Packages> allPackages = packageRepository.findByPackageCountry(destination);
        return allPackages.stream().map(this::mapToPackageDto).collect(Collectors.toList());
    }

    @Override
    public PackageDTO getPackageById(String packageId) {
        return mapToPackageDto(packageRepository.findByPackageID(packageId));
    }

    @Override
    public List<PackageDTO> getWishListById(String userId) {

        return null;
    }

    @Override
    public PackageDTO createPackage(PackageDTO packageDTO) {
        Packages pkg = Mapper.mapToPackageEntity(packageDTO);
        pkg.setCreatedDate(String.valueOf(new Date()));
        pkg.setUpdatedDate(String.valueOf(new Date()));
        Packages savedPackage = packageRepository.save(pkg);
        return Mapper.mapToPackageDto(savedPackage);
    }
}
