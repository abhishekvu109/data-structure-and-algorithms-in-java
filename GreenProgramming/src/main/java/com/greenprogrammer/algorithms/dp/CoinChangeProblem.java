package com.greenprogrammer.algorithms.dp;

import java.util.Arrays;
import java.util.Comparator;

public class CoinChangeProblem {


    public static int coinChange(int[] coins, int sum, int n) {
        if (n == 0)
            return 0;
        if (sum == 0)
            return 1;
        if (sum < 0)
            return 0;
        return coinChange(coins, sum, n - 1) + coinChange(coins, sum - coins[n - 1], n);
    }

    public static int coinChangeDp(int[] coins, int sum, int n) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = 1;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                dp[i][j] = dp[i - 1][j] + ((j - coins[i - 1] < 0) ? 0 : dp[i][j - coins[i - 1]]);
            }
        }
        return dp[n][sum];
    }

    public static void main(String args[]) {
//        int[] coins = {89, 62, 82, 87, 88, 53, 29, 16, 50, 95, 70, 32, 17, 57, 3, 61, 44, 91, 24, 72, 94, 34, 90, 52, 7, 65, 22, 15, 92, 38, 60, 63, 78, 64, 55, 36, 46, 85, 30, 11, 12, 33, 96, 45, 13, 4, 98, 40, 93, 83, 1, 42};
//        Arrays.sort(coins);
//        int sum = 432;
////        int numOfWays = coinChange(coins, sum, coins.length);
//        int numOfWaysDp = coinChangeDp(coins, sum, coins.length);
////        System.out.printf("Number of ways: %d", numOfWays);
//        System.out.printf("\nNumber of ways: %d %d", coins.length, numOfWaysDp);

        int[] coins = {1, 2, 5};
        int sum = 11;
        int numOfWays = coinChange(coins, sum, coins.length);
        int numOfWaysDp = coinChangeDp(coins, sum, coins.length);
        System.out.printf("Number of ways: %d", numOfWays);
        System.out.printf("\nNumber of ways: %d", numOfWaysDp);
    }
}
