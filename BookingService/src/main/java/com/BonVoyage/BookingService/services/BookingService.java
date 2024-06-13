package com.BonVoyage.BookingService.services;

import com.BonVoyage.BookingService.models.Bookings;
import com.BonVoyage.BookingService.payloads.BookingsDTO;
import com.BonVoyage.BookingService.payloads.NewUserBooking;

import java.util.List;

public interface BookingService {
    Bookings updateBooking(BookingsDTO bookings);

    List<Bookings> getAllBookingsById(String userId);

    Bookings editBookingsByBookingId(Bookings bookings);

    void deleteBookingById(String bookingId);

    NewUserBooking saveBooking(BookingsDTO bookings);
}
