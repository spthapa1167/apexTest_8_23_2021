package com.apex.satya.satyaApiWork.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class RewardUtilTest {
    /**
     * Test the point when transaction amount is greater than 50 and less than 100
     * A customer receives 2 points for every dollar spent over $100 in each transaction,
     * plus 1 point for every dollar spent over $50 in each transaction
     * (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
     * for transaction of 70.00 expect 20 points
     */
    @Test
    public void testAmountMoreThan50(){
        Double testInput = 70.00;

        Integer actualPoint = RewardUtil.calculatePoints(testInput);
        Integer expectedPoint = 20;
        assertEquals(expectedPoint, actualPoint);;

    }

    /**
     * Test the point when transaction amount is greater than 50 and less than 100
     * A customer receives 2 points for every dollar spent over $100 in each transaction,
     * plus 1 point for every dollar spent over $50 in each transaction
     * (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
     * for transaction of $120.00 expect 90 points
     */
    @Test
    public void testAmountMoreThan100(){
        Double testInput = 120.00;

        Integer actualPoint = RewardUtil.calculatePoints(testInput);
        Integer expectedPoint = 90;
        assertEquals(expectedPoint, actualPoint);;

    }

    /**
     * Test the point when transaction amount is greater than 50 and less than 100
     * A customer receives 2 points for every dollar spent over $100 in each transaction,
     * plus 1 point for every dollar spent over $50 in each transaction
     * (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
     * for zero dollar transaction expect 0 points.
     */
    @Test
    public void testAmountZero(){
        Double testInput = 0.00;

        Integer actualPoint = RewardUtil.calculatePoints(testInput);
        Integer expectedPoint = 0;
        assertEquals(expectedPoint, actualPoint);;

    }

    /**
     * Test the point when transaction amount is greater than 50 and less than 100
     * A customer receives 2 points for every dollar spent over $100 in each transaction,
     * plus 1 point for every dollar spent over $50 in each transaction
     * (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
     * For NULL input expect NullPointerException
     */
    @Test
    public void testAmountIsNotProvided(){
        Double testInput = null;
        assertThrows(NullPointerException.class, () -> {
            RewardUtil.calculatePoints(testInput);
        });
    }
}
