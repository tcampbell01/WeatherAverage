///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Weather Averages
// Course:          CS 200, Summer 2024
//
// Author:          Teresa Campbell
// Email:           tjcampbe@wisc.edu
// Lecturer's Name: Jim Williams
//
///////////////////////////////// CITATIONS ////////////////////////////////////
//
// I used ChatGPT to figure out how to use Junit
//
///////////////////////////////// REFLECTION ///////////////////////////////////
//
// 1. Describe the problem you wrote the program to solve: This app takes in the
//    high temperatures for the last 7 days and outputs the weekly average.
// 2. What are the biggest challenges you encountered: I thought the testing was
//    tricky. I wanted to use junit because this is what we use often at optum
//    and I wanted experience setting up the tests using junit.
// 3. What did you learn from this assignment: How to use junit for testing.
//
// Note: I did learn to use junit but resubmitting without junit because zybooks
//       isn't set up to use it
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

//package org.example;

import java.util.Scanner;

/**
 * This class contains a method to input numerical values into an array,
 * calculate the average temperature from these values, and print the result.
 */
public class H8CustomApp {

    /**
     * Calculates the average temperature from an array of temperatures.
     *
     * @param weeklyTemp Array of integer temperatures.
     * @return The average temperature as a double.
     */
    public static double averageTemp(int[] weeklyTemp) {
        int sum = 0;
        for (int temp : weeklyTemp) {
            sum += temp;
        }
        double average = (double) sum / weeklyTemp.length;
        return Math.round(average * 100.0) / 100.0;
    }

    /**
     * Main method to input numerical values into an array, confirm the input,
     * and print the average temperature.
     *
     * @param args Command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int NUM_VALUES = 7;
        int[] weeklyValues = new int[NUM_VALUES];
        int count = 0;

        while (count < NUM_VALUES) {
            System.out.println("Please enter the daily high temperature. " +
                    "Round to the nearest whole integer:");

            try {
                weeklyValues[count] = Integer.parseInt(input.nextLine().trim());
                count++;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer value.");
            }


            System.out.println("You entered:");
            for (int i = 0; i < count; i++) {
                System.out.print(weeklyValues[i] + " ");
            }
            System.out.println();

            if (count == NUM_VALUES) {
                boolean validInput = false;
                while (!validInput) {
                    System.out.println("Is this correct? Type Y or N");

                    if (input.hasNext()) {
                        String correct = input.next();
                        if (correct.equalsIgnoreCase("Y")) {
                            validInput = true;
                        } else if (correct.equalsIgnoreCase("N")) {
                            count = 0;
                            validInput = true;
                        } else {
                            System.out.println("Invalid input. " +
                                    "Please type Y or N.");
                        }
                    }
                }
            }
        }

        input.close();

        double averageTemperature = averageTemp(weeklyValues);
        System.out.println("The average temperature is: " + averageTemperature);

        boolean passed = TestH8CustomApp.testH8CustomApp();
        if (!passed) {
            System.out.println("Some tests failed.");
        }
    }
}