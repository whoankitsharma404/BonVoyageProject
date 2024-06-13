package com.BonVoyage.BookingService.repositories;

import com.BonVoyage.BookingService.models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookingsRepository extends JpaRepository<Bookings,String> {
    Bookings findByUserIDAndPackageID(String userId, String bookingPackageId);

    List<Bookings> findByUserID(String userId);

//    @Query("SELECT MAX(u.bookingID) FROM Bookings u")
//    String findMaxBookingsId();

    @Query("SELECT MAX(u.bookingID) FROM Bookings u")
    String findMaxBookingsId();


}
