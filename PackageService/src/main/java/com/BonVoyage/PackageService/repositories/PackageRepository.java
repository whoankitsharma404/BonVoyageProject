package com.BonVoyage.PackageService.repositories;

import com.BonVoyage.PackageService.models.Packages;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PackageRepository extends JpaRepository<Packages,String> {
}
