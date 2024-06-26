package com.BonVoyage.PackageService.models;

import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "packages")
public class Packages {

    @Id
    @Column(name = "package_id", nullable = false, unique = true)
    private String packageID;

    @Column(name = "package_country", nullable = false)
    private String packageCountry;

    @Column(name = "package_city", nullable = false)
    private String packageCity;

    @Column(name = "package_name", nullable = false, unique = true)
    private String packageName;

    @Column(name = "package_desc", nullable = false)
    private String packageDesc;

    @Column(name = "package_rating", nullable = false)
    private Double packageRating;

    @Column(name = "package_reviews", nullable = false)
    private Integer packageReviews;

    @Column(name = "package_price", nullable = false)
    private String packagePrice;

    @Column(name = "package_duration", nullable = false)
    private String packageDuration;

    @Column(name = "min_age", nullable = false)
    private String minAge;

    @Column(name = "max_people", nullable = false)
    private Integer maxPeople;

    @Column(name = "package_pickup", nullable = false)
    private String packagePickup;

    @Column(name = "available_date", nullable = false)
    private String availableDate;

    @Column(name = "package_language", nullable = false)
    private String packageLanguage;

    @Column(name = "package_image", nullable = false)
    private String packageImage;

    @Timestamp
    @Column(name = "created_date", nullable = false, unique = true)
    private String createdDate;

    @Timestamp
    @Column(name = "updated_date", nullable = false, unique = true)
    private String updatedDate;

}
