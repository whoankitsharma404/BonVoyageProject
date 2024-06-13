package com.BonVoyage.UsersWishListService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "users_wish_list")
public class UsersWishList {

    @Id
    @Column(name = "user_id", nullable = false)
    private String userID;

    @Column(name = "wish_list_id", nullable = false)
    private String WishlistID;

}

