package com.BonVoyage.BookingService.services.impl;

import com.BonVoyage.BookingService.models.Bookings;
import com.BonVoyage.BookingService.payloads.BookingsDTO;
import com.BonVoyage.BookingService.payloads.NewUserBooking;
import com.BonVoyage.BookingService.repositories.BookingsRepository;
import com.BonVoyage.BookingService.services.BookingService;
import com.BonVoyage.BookingService.utils.IdGeneration;
import com.thoughtworks.xstream.mapper.Mapper;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.IdGenerator;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingsRepository bookingsRepository;


    @Override
    public Bookings updateBooking(BookingsDTO bookings) {

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

    @Override
    public void deleteBookingById(String bookingId) {
        bookingsRepository.deleteById(bookingId);
    }

    @Override
    public NewUserBooking saveBooking(BookingsDTO bookings) {

        String lastValue = bookingsRepository.findMaxBookingsId();

        Bookings newUserBooking = Bookings.builder()
                .bookingID(IdGeneration.generateNextBookingId(lastValue))
                .bookingCost(bookings.getBookingCost())
                .bookingDate(String.valueOf(new Date()))
                .build();

        Bookings savedBookings =bookingsRepository.save(newUserBooking);

        NewUserBooking newUserBooking1 = NewUserBooking.builder()
                .bookingCost(savedBookings.getBookingCost())
                .bookingDate(savedBookings.getBookingDate())
//                .booking
                .build();

        return null;

    }
}
