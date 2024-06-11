package com.BonVoyage.PackageService.payloads;

import jakarta.persistence.Column;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PackageDTO {

    private String packageID;

    private String packageCountry;

    private String packageCity;

    private String packageName;

    private String packageDesc;

    private Double packageRating;

    private Integer packageReviews;

    private String packagePrice;

    private String packageDuration;

    private String minAge;

    private Integer maxPeople;

    private String packagePickup;

    private String availableDate;

    private String packageLanguage;

    private String packageImage;

    private String createdDate;

    private String updatedDate;


}
