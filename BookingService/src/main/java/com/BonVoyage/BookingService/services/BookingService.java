package com.BonVoyage.BookingService.services;

import com.BonVoyage.BookingService.models.Bookings;
import com.BonVoyage.BookingService.payloads.UpdateBookingsDTO;
import org.springframework.http.HttpStatusCode;

import java.awt.print.Book;
import java.util.List;

public interface BookingService {
    Bookings updateBooking(UpdateBookingsDTO bookings);

    List<Bookings> getAllBookingsById(String userId);

    Bookings editBookingsByBookingId(Bookings bookings);
}
