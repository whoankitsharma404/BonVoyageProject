package com.BonVoyage.PackageService.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "package_itenary")
public class PackageItenary {

    @Id
    @Column(name = "itenary_id")
    private String itenaryID;

    @Column(name = "package_id", nullable = false)
    private String packageID;

    @Column(name = "day", nullable = false)
    private String day;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "activities", nullable = false)
    private String activities;

}
