package com.BonVoyage.BookingService.services;

import com.BonVoyage.BookingService.models.Bookings;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public interface BookingService {
    Bookings updateBooking(Bookings bookings);

    Bookings getAdminDetails();

    List<Bookings> getAllBookingsById(String userId);

    Bookings editBookingsByBookingId(Bookings bookings);
}
