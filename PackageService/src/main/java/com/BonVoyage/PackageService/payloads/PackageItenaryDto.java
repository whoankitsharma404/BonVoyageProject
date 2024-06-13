package com.BonVoyage.PackageService.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PackageItenaryDto {
    private String itenaryID;

    private String packageID;

    private String day;

    private String title;

    private String activities;

}
