package com.BonVoyage.PackageItenaryService.services.impl;

import com.BonVoyage.PackageItenaryService.models.PackageItenary;
import com.BonVoyage.PackageItenaryService.payload.PackageItenaryDto;
import com.BonVoyage.PackageItenaryService.repository.PackageItenaryRepository;
import com.BonVoyage.PackageItenaryService.services.PackageItenaryService;
import com.BonVoyage.PackageItenaryService.utils.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PackageItenaryServiceImpl implements PackageItenaryService {

    private PackageItenaryRepository packageItenaryRepository;

    @Override
    public List<PackageItenaryDto> getAllPackageItenary(String packageId) {
        List<PackageItenary> allPackagesItenery = packageItenaryRepository.findAll();
        return allPackagesItenery.stream().map(this::mapToPackageItenaryDto).collect(Collectors.toList());

    }

    private PackageItenaryDto mapToPackageItenaryDto(PackageItenary packageItenary) {
        PackageItenaryDto packageItenaryDto = new PackageItenaryDto();
        packageItenaryDto.setItenaryID(packageItenary.getItenaryID());
        packageItenaryDto.setPackageID(packageItenary.getPackageID());
        packageItenaryDto.setDay(packageItenary.getDay());
        packageItenaryDto.setTitle(packageItenary.getTitle());
        packageItenaryDto.setActivities(packageItenary.getActivities());
        return packageItenaryDto;
    }
}
