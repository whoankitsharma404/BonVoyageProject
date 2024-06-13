package com.BonVoyage.BookingService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "bookings")
public class Bookings {

    @Id
    @Column(name = "booking_id", nullable = false, unique = true)
    private String bookingID;

    @Column(name = "user_id", nullable = true)
    private String userID;

    @Column(name = "package_id", nullable = true)
    private String packageID;

    @Column(name = "package_name", nullable = true)
    private String packageName;

    @Column(name = "package_image", nullable = true)
    private String packageImage;

    @Column(name = "booking_person", nullable = true)
    private Integer bookingPerson;

    @Column(name = "booking_rooms", nullable = true)
    private Integer bookingRooms;

    @Column(name = "booking_date", nullable = false)
    private String bookingDate;

    @Column(name = "booking_cost", nullable = false)
    private Double bookingCost;
}
