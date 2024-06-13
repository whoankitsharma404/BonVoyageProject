package com.BonVoyage.UserService.payloads;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookingsDTO {
    private String bookingPackageId;
    private String bookingDate;
    private Long bookingPerson;
    private Long bookingRoom;
    private Double bookingCost;
}
