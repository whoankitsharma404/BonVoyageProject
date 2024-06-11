package com.BonVoyage.BookingService.services.impl;

import com.BonVoyage.BookingService.models.Bookings;
import com.BonVoyage.BookingService.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {
    @Override
    public Bookings updateBooking(Bookings bookings) {
        return null;
    }

    @Override
    public Bookings getAdminDetails() {
        return null;
    }

    @Override
    public List<Bookings> getAllBookingsById(String userId) {
        return null;
    }

    @Override
    public Bookings editBookingsByBookingId(Bookings bookings) {
        return null;
    }
}
