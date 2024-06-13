package com.BonVoyage.PackageItenaryService.repository;

import com.BonVoyage.PackageItenaryService.models.PackageItenary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageItenaryRepository extends JpaRepository<PackageItenary,String> {
    List<PackageItenary> findByPackageID(String packageId);
}
