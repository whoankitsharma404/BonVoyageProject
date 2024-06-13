package com.BonVoyage.BookingService.controllers;

import com.BonVoyage.BookingService.models.Bookings;
import com.BonVoyage.BookingService.payloads.ApiResponse;
import com.BonVoyage.BookingService.payloads.BookingsDTO;
import com.BonVoyage.BookingService.payloads.NewUserBooking;
import com.BonVoyage.BookingService.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class BookingController {

    private BookingService bookingService;

    @PutMapping
    public ResponseEntity<?> updateUserBooking(@RequestBody BookingsDTO bookings){
        Bookings bookingsDTO =null;
        try{
            bookingsDTO = bookingService.updateBooking(bookings);
            return new ResponseEntity<>(new ApiResponse(bookingsDTO,"success",1),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(bookingsDTO,"failed",0),HttpStatus.OK);
        }
    }

    @PostMapping("/bookings/{userID}/{packageID}")
    public ResponseEntity<?> userBooking(@PathVariable String userID, @PathVariable String packageID){
        Bookings bookingsDTO =null;
        try{
            bookingsDTO = bookingService.saveBooking(userID,packageID);
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

    @DeleteMapping("/booking/{bookingId}")
    public ResponseEntity<?> deleteBookingByBookingId(String bookingId){
        Map<String,Integer> responseMap = new HashMap<>();
        try{
            bookingService.deleteBookingById(bookingId);
            return new ResponseEntity<>(new ApiResponse(responseMap.put("deletedCount",1),"success",1),HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(new ApiResponse(responseMap.put("deletedCount",0),"failed",0),HttpStatus.OK);
        }
    }


}
