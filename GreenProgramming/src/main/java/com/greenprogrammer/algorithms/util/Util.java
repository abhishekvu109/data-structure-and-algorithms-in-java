package com.greenprogrammer.algorithms.util;

public class Util {
    public static void print2DArray(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            // Iterate through the columns
            for (int j = 0; j < dp[i].length; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println(); // Move to the next line for the next row
        }

    }
}
