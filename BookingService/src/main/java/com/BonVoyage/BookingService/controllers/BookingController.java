package com.BonVoyage.BookingService.controllers;

import com.BonVoyage.BookingService.models.Bookings;
import com.BonVoyage.BookingService.services.BookingService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookingController {

    private BookingService bookingService;

    @PutMapping
    public ResponseEntity<Bookings> updateUserBooking(@RequestBody Bookings bookings){
        return new ResponseEntity<>(this.bookingService.updateBooking(bookings), HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<Bookings> adminDetailsWithBookings(){
        return new ResponseEntity<>(this.bookingService.getAdminDetails(), HttpStatus.OK);
    }

    @GetMapping("/booking/{userId}")
    public ResponseEntity<List<Bookings>> getAllBookingsByUserId(String userId){
        return new ResponseEntity<>(this.bookingService.getAllBookingsById(userId),HttpStatus.OK);
    }

    @PutMapping("/editBookings")
    public ResponseEntity<Bookings> editBookingsById(@RequestBody Bookings bookings){
        return new ResponseEntity<>(this.bookingService.editBookingsByBookingId(bookings), HttpStatus.OK);
    }

}
