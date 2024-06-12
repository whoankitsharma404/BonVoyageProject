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

    @Column(name = "user_id", nullable = false)
    private String userID;

    @Column(name = "package_id", nullable = false)
    private String packageID;

    @Column(name = "package_name", nullable = false)
    private String packageName;

    @Column(name = "package_image", nullable = false)
    private String packageImage;

    @Column(name = "booking_person", nullable = false)
    private Integer bookingPerson;

    @Column(name = "booking_rooms", nullable = false)
    private Integer bookingRooms;

    @Column(name = "booking_date", nullable = false)
    private String bookingDate;
}
