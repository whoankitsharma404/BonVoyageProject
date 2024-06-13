package com.BonVoyage.UserService.utils;

import com.BonVoyage.UserService.repositories.UserRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IdGeneration {

    public static String generateNextUserId(String maxUserId) {
        if (maxUserId == null) {
            return "U101";
        }

        int numericPart = Integer.parseInt(maxUserId.substring(1));
        String newUserId = "U" + (numericPart + 1);
        return newUserId;
    }

    public static String generateNextPackageId(String maxUserId) {
        if (maxUserId == null) {
            return "P101";
        }

        int numericPart = Integer.parseInt(maxUserId.substring(1));
        String newUserId = "P" + (numericPart + 1);
        return newUserId;
    }

    public static String generateNextBookingId(String maxUserId) {
        if (maxUserId == null) {
            return "B101";
        }

        int numericPart = Integer.parseInt(maxUserId.substring(1));
        String newUserId = "B" + (numericPart + 1);
        return newUserId;
    }

}
