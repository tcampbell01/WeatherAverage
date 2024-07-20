///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Weather Averages
// Course:          CS 200, Summer 2024, Jim Williams
//
// Author:          Teresa Campbell
// Email:           tjcampbe@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// None
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

package org.example;

/**
 * This class contains test cases for the H8CustomApp class.
 * It verifies the correctness of the averageTemp method by testing
 * different scenarios and edge cases.
 */
public class TestH8CustomApp {

    /**
     * Test to verify that the averageTemp method calculates the average
     * temperature correctly for a typical set of weekly temperatures.
     *
     * @return boolean - Returns true if the test passes, false otherwise.
     */
    public static boolean testAverageTemp() {
        boolean error = false;

        // Test case 1: Weekly temperatures with positive values
        {
            int[] weeklyTemp = {30, 32, 31, 29, 28, 33, 34};
            double expectedAverage = 31.0;
            double result = H8CustomApp.averageTemp(weeklyTemp);
            if (Math.abs(expectedAverage - result) >= 0.001) {
                error = true;
                System.out.println("testAverageTemp 1) Expected: " +
                        expectedAverage + ", Result: " + result);
            }
        }

        // Test case 2: Weekly temperatures with negative values
        {
            int[] weeklyTemp = {-5, 0, 5, 10, 15, -10, 20};
            double expectedAverage = 5.0;
            double result = H8CustomApp.averageTemp(weeklyTemp);
            if (Math.abs(expectedAverage - result) >= 0.001) {
                error = true;
                System.out.println("testAverageTemp 2) Expected: " +
                        expectedAverage + ", Result: " + result);
            }
        }

        // Test case 3: Weekly temperatures with all same values
        {
            int[] weeklyTemp = {20, 20, 20, 20, 20, 20, 20};
            double expectedAverage = 20.0;
            double result = H8CustomApp.averageTemp(weeklyTemp);
            if (Math.abs(expectedAverage - result) >= 0.001) {
                error = true;
                System.out.println("testAverageTemp 3) Expected: " +
                        expectedAverage + ", Result: " + result);
            }
        }

        return !error;
    }

    /**
     * Method to run all tests and print the results.
     *
     * @return boolean - Returns true if all tests pass, false otherwise.
     */
    public static boolean testH8CustomApp() {
        boolean passed = true;

        if (!testAverageTemp()) {
            passed = false;
            System.out.println("testAverageTemp failed");
        }

        if (passed) {
            System.out.println("All tests passed.");
        } else {
            System.out.println("Some tests failed.");
        }

        return passed;
    }

    /**
     * Main method to execute the test cases.
     *
     * @param args Command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        boolean passed =
                testH8CustomApp();
    }
}
