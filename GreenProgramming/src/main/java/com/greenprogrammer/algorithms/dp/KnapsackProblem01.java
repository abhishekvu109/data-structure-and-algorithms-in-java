package com.greenprogrammer.algorithms.dp;

public class KnapsackProblem01 {
    public static int knapsackProblem(int[] v, int[] w, int n, int W) {
        if (n == 0)
            return (W >= 0) ? 0 : Integer.MIN_VALUE;
        if (W < 0)
            return Integer.MIN_VALUE;
        int exclude = knapsackProblem(v, w, n - 1, W);
        int include = knapsackProblem(v, w, n - 1, W - w[n - 1]);
        return Math.max(exclude, ((include >= 0) ? v[n - 1] : Integer.MIN_VALUE) + include);
    }

    public static int knapsackProblemDp(int[] v, int[] w, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];
        dp[0][0] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int exclude = dp[i - 1][j];
                int include = (j - w[i - 1] < 0) ? Integer.MIN_VALUE : dp[i - 1][j - w[i - 1]];
                dp[i][j] = Math.max(exclude, ((include >= 0) ? v[i - 1] + include : Integer.MIN_VALUE));
            }
        }

        return dp[n][W];
    }

    public static void main(String args[]) {
        int[] w = {4,5,1};
        int[] v = {1,2,3};
        int W = 4;
        int n = w.length;
        int knapsack = knapsackProblem(v, w, n, W);
        int knapsackDp = knapsackProblemDp(v, w, n, W);
        System.out.printf("\n The maximum value can be: %d", knapsack);
        System.out.printf("\n The maximum value can be: %d", knapsackDp);
    }
}
