package com.BonVoyage.BookingService.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingsDTO {

    private String userId;
    private String bookingPackageId;
    private String bookingDate;
    private Long bookingPerson;
    private Long bookingRoom;
    private Double bookingCost;
}
