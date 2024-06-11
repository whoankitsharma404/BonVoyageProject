package com.BonVoyage.PackageService.repositories;

import com.BonVoyage.PackageService.models.Packages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PackageRepository extends JpaRepository<Packages,String> {
    List<Packages> findByPackageCountry(String destination);
}
