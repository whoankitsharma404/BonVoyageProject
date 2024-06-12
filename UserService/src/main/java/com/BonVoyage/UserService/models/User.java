package com.BonVoyage.UserService.models;

import com.BonVoyage.UserService.enums.UserRole;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "users")
public class User {

    @Id
    @Column(name = "user_id", nullable = false, unique = true)
    private String userID;

    @Column(name = "user_name", nullable = false)
    private String userName;

    @Column(name = "user_email", nullable = false, unique = true)
    private String userEmail;

    @Column(name = "user_phone", nullable = false, unique = true)
    private Long userPhone;

    @Column(name = "user_password", nullable = false)
    private String userPassword;

    @Column(name = "user_address", nullable = false)
    private String userAddress;

//    @Column(name = "user_role", nullable = false)
//    private String userRole;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role", nullable = false)
    private UserRole userRole;

    @Timestamp
    @Column(name = "created_at", nullable = false, unique = true)
    private String createdAt;

    @Timestamp
    @Column(name = "updated_at", nullable = false, unique = true)
    private String updatedAt;

    @Column(name = "__v", nullable = false)
    private int version;
}
