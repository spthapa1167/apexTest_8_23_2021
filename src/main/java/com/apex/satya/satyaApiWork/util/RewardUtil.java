package com.apex.satya.satyaApiWork.util;

public class RewardUtil {
    public static Integer calculatePoints(Double amount){
        Integer points = 0;

        if (amount > 50 && amount <= 100) {
            points += (amount.intValue() - 50) * 1;

        }

        if (amount > 100) {
            points += 50;
            points += (amount.intValue() - 100) * 2;
        }

        return points;
    }
}
