package com.BonVoyage.BookingService.payloads;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewUserBooking {
    private String bookingDate;
    private Long bookingRoom;
    private Double bookingCost;
}
