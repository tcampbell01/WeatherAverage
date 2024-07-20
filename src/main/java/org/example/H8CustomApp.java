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
// I went to office hours with Victor and asked for help
//
///////////////////////////////// REFLECTION ///////////////////////////////////
//
// 1. Describe the problem you wrote the program to solve: This app takes in the
//    high temperatures for the last 7 days and outputs the weekly average.

// 2. What are the biggest challenges you encountered: I thought the testing was
//    tricky. I wanted to use junit because this is what we use often at optum
//    and I wanted experience setting up the tests using junit.
//
//   I am adding to this question because I have spent many days trying to
//   figure out why my code has an infinite loop.  I've tried everything.
//   In my local testing it doesn't show an infinite loop,
//   but when I try to upload it to zybooks it does. I finally took my code and
//   divided it into many different methods to see if I could eliminate the
//   infinite loop.
//
//   Final note: Originally, my code asked if the input was correct, and if the
//  user entered 'N', it went back to the beginning and asked the user to input
//  temperatures again.  This seemed to cause the infinite loop on zybooks and I
//  could not figure out how to fix it.  After meeting with the TA, and
//  submitting my program 30 different times, I chose to terminate the program
// if the user chose N.
//
//
// 3. What did you learn from this assignment: How to use junit for testing.
//
// Note: I did learn to use junit but resubmitting without junit because zybooks
//       isn't set up to use it
//
//
//
/////////////////////////////// 80 COLUMNS WIDE ////////////////////////////////


package org.example;

import java.util.Scanner;

/**
 * H8CustomApp is a program to input daily high temperatures, calculate the
 * average temperature, and validate the input through user confirmation.
 */

public class H8CustomApp {

    /**
     * Calculates the average temperature from an array of temperatures.
     *
     * @param weeklyTemp Array of integer temperatures.
     * @return The average temperature, rounded to the nearest hundredths,
     * as a double.
     */
    public static double averageTemp(int[] weeklyTemp) {
        int sum = 0;
        for (int temp : weeklyTemp) {
            sum += temp;
        }
        return Math.round((double) sum / weeklyTemp.length * 100.0) / 100.0;
    }

    /**
     * Main method to input numerical values into an array, confirm the input,
     * calculate the average temperature, and print the result.
     *
     * @param args Command-line arguments (not used in this implementation).
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int NUM_VALUES = 7;
        int[] weeklyValues = new int[NUM_VALUES];

        while (true) {
            int count = getDailyTemperatures(input, weeklyValues, NUM_VALUES);
            displayTemperatures(weeklyValues, count);

            boolean validInput = confirmInput(input, weeklyValues);
            if (validInput) {
                double averageTemperature = averageTemp(weeklyValues);
                System.out.println("The average temperature is: " +
                        averageTemperature);

                // Call the test method
                boolean passed = TestH8CustomApp.testH8CustomApp();
                break; // Exit the loop after processing
            } else {
                break; // Exit the loop if input is invalid or user chooses 'N'
            }
        }
        input.close();
    }

    /**
     * Prompts the user to enter daily high temperatures until the specified
     * number
     * of values has been collected.
     *
     * @param input        The Scanner object for user input.
     * @param weeklyValues Array to store the entered temperatures.
     * @param numValues    The number of values to collect.
     * @return The number of valid temperatures entered.
     */
    private static int getDailyTemperatures(Scanner input, int[] weeklyValues,
                                            int numValues) {
        int count = 0;
        while (count < numValues) {
            System.out.println("Please enter the daily high temperature. " +
                    "Round to the nearest whole integer:");

            if (input.hasNextInt()) {
                weeklyValues[count] = input.nextInt();
                count++;
            } else if (input.hasNext()) {
                System.out.println("Invalid input. Please try again.");
                input.next(); // Consume the invalid input
            } else {
                System.out.println("No input or invalid input detected. " +
                        "Please start again " +
                        "when " +
                        "you are ready..");
                break;
            }
        }
        return count;
    }

    /**
     * Displays the entered temperatures to the user.
     *
     * @param weeklyValues Array of entered temperatures.
     * @param count        The number of temperatures that were entered.
     */
    private static void displayTemperatures(int[] weeklyValues, int count) {
        System.out.println("You entered:");
        for (int i = 0; i < count; i++) {
            System.out.print(weeklyValues[i] + " ");
        }
        System.out.println();
    }

    /**
     * Confirms the user's input by asking if the values entered are correct.
     * If the user inputs 'N', the temperature input process is restarted.
     *
     * @param input        The Scanner object for user input.
     * @param weeklyValues Array to store the entered temperatures.
     * @return True if the user confirms the input is correct, false otherwise.
     */
    private static boolean confirmInput(Scanner input, int[] weeklyValues) {
        boolean validInput = false;

        while (!validInput) {
            System.out.println("Is this correct? Type Y or N");

            // Check for input availability
            if (input.hasNext()) {
                String correct = input.next();

                if (correct.equalsIgnoreCase("Y")) {
                    validInput = true; // Exit loop on confirmation
                } else if (correct.equalsIgnoreCase("N")) {
                    System.out.println("Sorry you are having trouble. " +
                            "Please " +
                            "try again later.");
                    return false; // End the program
                } else {
                    System.out.println("That was an invalid entry. Please " +
                            "try " +
                            "again later.");
                    return false; // End the program
                }
            } else {
                System.out.println("No input detected. Please enter Y or N.");
                return false; // End the program
            }
        }
        return validInput;
    }
}
