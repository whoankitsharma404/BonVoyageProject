package com.BonVoyage.UserService.payloads;

import com.BonVoyage.UserService.enums.UserRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginResponse {
    private String userID;
    private String userName;
    private String userEmail;
    private Long userPhone;
    private String userAddress;
    private UserRole userRole;

}
