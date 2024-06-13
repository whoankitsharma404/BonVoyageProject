package com.BonVoyage.UserService.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "users_wish_list")
public class UsersWishList {


    @Column(name = "user_id", nullable = false)
    private String userID;

    @Column(name = "package_id", nullable = false)
    private String packageID;

    @Id
    @Column(name = "wish_list_id", nullable = false)
    private String wishlistID;

}
