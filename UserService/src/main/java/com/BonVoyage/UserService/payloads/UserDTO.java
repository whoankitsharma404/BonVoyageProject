package com.BonVoyage.UserService.payloads;

import com.BonVoyage.UserService.enums.UserRole;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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

    private String createdDate;
    private String updatedDate;
    private int version;

}

