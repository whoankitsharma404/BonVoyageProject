package com.BonVoyage.PackageService.external;

import com.BonVoyage.PackageService.payloads.PackageItenaryDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "PACKAGEITENARYSERVICE")
public interface PackageItenaryService {

    @GetMapping("/package/{packageID}")
    List<PackageItenaryDto> getPackageItenary(@PathVariable(name = "packageID") String packageID);

}
