package com.BonVoyage.BookingService.services.impl;

import com.BonVoyage.BookingService.models.Bookings;
import com.BonVoyage.BookingService.payloads.UpdateBookingsDTO;
import com.BonVoyage.BookingService.repositories.BookingsRepository;
import com.BonVoyage.BookingService.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingsRepository bookingsRepository;


    @Override
    public Bookings updateBooking(UpdateBookingsDTO bookings) {

        Bookings newBookingData = bookingsRepository.findByUserIDAndPackageID(bookings.getUserId(),bookings.getBookingPackageId());
        return Bookings.builder()
                .bookingDate(newBookingData.getBookingDate())
                .bookingPerson(newBookingData.getBookingPerson())
                .bookingRooms(newBookingData.getBookingRooms()).build();
    }


    @Override
    public List<Bookings> getAllBookingsById(String userId) {
        return bookingsRepository.findByUserID(userId);

    }

    @Override
    public Bookings editBookingsByBookingId(Bookings bookings) {
        return null;
    }
}
