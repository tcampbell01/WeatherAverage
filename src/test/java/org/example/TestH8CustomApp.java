package org.example;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * This class contains test cases for the H8CustomApp class.
 * It verifies the correctness of the AverageTemp method by testing
 * different scenarios and edge cases.
 */
public class TestH8CustomApp {

    /**
     * Test to verify that the AverageTemp method calculates the average
     * temperature correctly for a typical set of weekly temperatures.
     */
    @Test
    public void testAverageTemp() {
        int[] weeklyTemp = {30, 32, 31, 29, 28, 33, 34};
        double expectedAverage = 31.0;
        assertEquals(expectedAverage, H8CustomApp.AverageTemp(weeklyTemp), 0.001);
    }

    /**
     * Test to verify that the AverageTemp method calculates the average
     * temperature correctly when the array contains negative values.
     */
    @Test
    public void testAverageTempWithNegatives() {
        int[] weeklyTemp = {-5, 0, 5, 10, 15, -10, 20};
        double expectedAverage = 5.0;
        assertEquals(expectedAverage, H8CustomApp.AverageTemp(weeklyTemp), 0.001);
    }

    /**
     * Test to verify that the AverageTemp method calculates the average
     * temperature correctly when all values in the array are the same.
     */
    @Test
    public void testAverageTempWithAllSameValues() {
        int[] weeklyTemp = {20, 20, 20, 20, 20, 20, 20};
        double expectedAverage = 20.0;
        assertEquals(expectedAverage, H8CustomApp.AverageTemp(weeklyTemp), 0.001);
    }
}
