package com.greenprogrammer.algorithms.dp;

import java.util.Arrays;

public class MinimumNumberOfCoins {
    public static int minCoins(int[] coins, int n, int sum, int count) {
        if (n == 0) {
            return (sum == 0) ? count : Integer.MAX_VALUE;
        }
        if (sum < 0)
            return Integer.MAX_VALUE;
        return Math.min(minCoins(coins, n - 1, sum, count), minCoins(coins, n, sum - coins[n - 1], count + 1));
    }

    public static int minCoins2(int[] coins, int n, int sum) {
        if (n == 0) {
            return (sum == 0) ? 0 : Integer.MAX_VALUE;
        }
        if (sum < 0)
            return Integer.MAX_VALUE;
        int exclude = minCoins2(coins, n - 1, sum);
        int include = minCoins2(coins, n, sum - coins[n - 1]);
        return Math.min(exclude, (include != Integer.MAX_VALUE) ? 1 + include : Integer.MAX_VALUE);
    }

    public static int minCoins(int[] coins, int targetSum) {
        int n = coins.length;
        int[][] dp = new int[n + 1][targetSum + 1];
        for (int i = 0; i < targetSum + 1; i++)
            dp[0][i] = Integer.MAX_VALUE;

        for (int i = 0; i < n + 1; i++)
            dp[i][0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < targetSum + 1; j++) {
                int exclude = dp[i - 1][j];
                int include = (j - coins[i - 1] < 0) ? Integer.MAX_VALUE : dp[i][j - coins[i - 1]];
                dp[i][j] = Math.min(exclude, (include != Integer.MAX_VALUE) ? 1 + include : Integer.MAX_VALUE);
            }
        }
        return dp[n][targetSum];
    }


    public static void main(String args[]) {
        int[] coins = {9, 6, 5, 1};
        int n = coins.length;
        int sum = 11;
        int count = 0;
        Integer ans = minCoins(coins, n, sum, count);
        Integer ansDp = minCoins(coins, sum);
        Integer ans2 = minCoins2(coins, n, sum);
        System.out.printf("The minimum number of coins required: %d", (ans == Integer.MAX_VALUE) ? -1 : ans);
        System.out.printf("\nThe minimum number of coins required: %d", ansDp);
        System.out.printf("\nThe minimum number of coins required: %d", ans2);
    }
}
