package com.greenprogrammer.algorithms.dp;

import com.greenprogrammer.algorithms.util.Util;

import java.util.stream.Stream;

public class MaximumNumberOfCuts {
    public static int maximumNumberOfCutsRec(int[] arr, int sum, int n) {
        if (n == 0)
            return (sum == 0) ? 0 : Integer.MIN_VALUE;
        if (sum < 0)
            return Integer.MIN_VALUE;
        if (sum == 0)
            return 0;
        int noPick = maximumNumberOfCutsRec(arr, sum, n - 1);
        int pick = maximumNumberOfCutsRec(arr, sum - arr[n - 1], n);
        return Math.max(noPick, (pick >= 0) ? 1 + pick : Integer.MIN_VALUE);
    }

    public static int maximumNumberOfCutsDp(int sum, int a, int b, int c) {
        int[] arr = {a, b, c};
        int n = arr.length;
        int[][] dp = new int[n + 1][sum + 1];
        for (int j = 0; j < sum + 1; j++)
            dp[0][j] = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++)
            dp[i][0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int exclude = dp[i - 1][j];
                int include = (j - arr[i - 1] < 0) ? Integer.MIN_VALUE : dp[i][j - arr[i - 1]];
                dp[i][j] = Math.max(exclude, include >= 0 ? 1 + include : Integer.MIN_VALUE);
            }
        }
        return dp[n][sum];
    }

    public static int maximumNumberOfCuts(int n, int a, int b, int c) {
        int[] arr = {a, b, c};
        int abc = maximumNumberOfCutsRec(arr, n, 3);
        return (abc == Integer.MIN_VALUE) ? -1 : abc;
    }

    public static void main(String args[]) {
        int a = 5, b = 5, c = 2, sum = 7;
        System.out.printf("The maximum number of cuts required: %d", maximumNumberOfCuts(sum, a, b, c));
        System.out.printf("\nThe maximum number of cuts required: %d", maximumNumberOfCutsDp(sum, a, b, c));
    }
}
