package com.BonVoyage.UserService.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsersWishListDTO {
    private String userID;
    private String WishlistID;
}
