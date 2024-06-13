package com.BonVoyage.UserService.payloads;

import com.BonVoyage.UserService.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {

    private String userID;

    private String userName;

    private String userEmail;

    private Long userPhone;

    private String userPassword;

    private String userAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

    private String createdAt;
    private String updatedAt;
    private int version;

    private List<UsersWishListDTO> userWishlist;
    private List<BookingsDTO> userBooking;

}

