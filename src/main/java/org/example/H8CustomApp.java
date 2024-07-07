package org.example;

///////////////////////// TOP OF FILE COMMENT BLOCK ////////////////////////////
//
// Title:           Weekly Averages
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
//
//
//
///////////////////////////////// REFLECTION ///////////////////////////////////
//
// 1. Describe the problem you wrote the program to solve: This app takes in the
// high temperatures for the last 7 days and outputs the weekly average.
// 2. What are the biggest challenges you encountered: I thought the testing was
// tricky.  I wanted to use junit because this is what we use often at optum and
// I wanted experience setting up the tests using junit.
// 3. What did you learn from this assignment: How to use junit for testing.
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////

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
    public static double AverageTemp(int[] weeklyTemp) {
        int sum = 0;
        for (int temp : weeklyTemp) {
            sum += temp;
        }
        return (double) sum / weeklyTemp.length;
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
        String correct = "N";

        // Get array values
        while (correct.equals("N")) {
            for (int i = 0; i < weeklyValues.length; i++) {
                System.out.println("Please enter the daily high temperature. Round to the nearest whole integer:");
                weeklyValues[i] = input.nextInt();
                input.nextLine(); // Clear the buffer after nextInt()
            }
            System.out.println("You entered:");
            for (int value : weeklyValues) {
                System.out.print(value + " ");
            }
            System.out.println();

            System.out.println("Is this correct? Type Y or N");
            correct = input.nextLine();

            if (correct.equals("Y")) {
                break;
            }
        }
        input.close();

        // Pass the array to AverageTemp method
        double averageTemperature = AverageTemp(weeklyValues);
        System.out.println("The average temperature is: " + averageTemperature);
    }
}
