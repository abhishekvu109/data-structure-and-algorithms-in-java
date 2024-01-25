package com.greenprogrammer.algorithms.dp;

import java.util.Arrays;
import java.util.stream.Stream;

public class MaximumSumWithNoConsecutives {
    public static int maxWithNoConsecutive(int[] arr, int n) {
        if (n <= 0)
            return 0;
        int include = maxWithNoConsecutive(arr, n - 1);
        int exclude = arr[n - 1] + maxWithNoConsecutive(arr, n - 2);
        return Math.max(include, exclude);
    }

    public static int maxWithNoConsecutiveDp(int[] arr, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int include = dp[i - 1];
            int exclude = arr[i - 1] + ((i - 2 < 0) ? 0 : dp[i - 2]);
            dp[i] = Math.max(include, exclude);
        }

        return dp[n] != 0 ? dp[n] : Arrays.stream(arr).max().orElse(0);
    }

    public static void main(String args[]) {
//        int[] arr = {8, 7, 6, 10};
        int[] arr = {-59, -91, -230, -114, -492};
        int n = arr.length;
        int maxConsecutives = maxWithNoConsecutive(arr, n);
        maxConsecutives = maxConsecutives != 0 ? maxConsecutives : Arrays.stream(arr).max().orElse(0);
        int maxConsecutivesDp = maxWithNoConsecutiveDp(arr, n);
        System.out.printf("The maximum sum with no consecutives: %d", maxConsecutives);
        System.out.printf("\nThe maximum sum with no consecutives: %d", maxConsecutivesDp);
    }
}
