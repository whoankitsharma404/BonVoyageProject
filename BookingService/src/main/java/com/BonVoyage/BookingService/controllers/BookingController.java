package com.BonVoyage.BookingService.controllers;

import com.BonVoyage.BookingService.models.Bookings;
import com.BonVoyage.BookingService.payloads.ApiResponse;
import com.BonVoyage.BookingService.payloads.UpdateBookingsDTO;
import com.BonVoyage.BookingService.services.BookingService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

@RestController
@AllArgsConstructor
public class BookingController {

    private BookingService bookingService;

    @PutMapping
    public ResponseEntity<?> updateUserBooking(@RequestBody UpdateBookingsDTO bookings){
        Bookings bookingsDTO =null;
        try{
            bookingsDTO = bookingService.updateBooking(bookings);
            return new ResponseEntity<>(new ApiResponse(bookingsDTO,"success",1),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(bookingsDTO,"failed",0),HttpStatus.OK);
        }
    }



    @GetMapping("/booking/{userId}")
    public ResponseEntity<?> getAllBookingsByUserId(String userId){
        List<Bookings> bookingsDTOList =null;
        try{
            bookingsDTOList = bookingService.getAllBookingsById(userId);
            return new ResponseEntity<>(new ApiResponse(bookingsDTOList,"success",bookingsDTOList.size()),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(bookingsDTOList,"failed",0),HttpStatus.OK);
        }
    }

    @PutMapping("/editBookings")
    public ResponseEntity<Bookings> editBookingsById(@RequestBody Bookings bookings){
        return new ResponseEntity<>(this.bookingService.editBookingsByBookingId(bookings), HttpStatus.OK);
    }

}
