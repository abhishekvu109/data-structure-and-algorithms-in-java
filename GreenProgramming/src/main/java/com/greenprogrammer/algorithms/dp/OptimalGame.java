package com.greenprogrammer.algorithms.dp;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class OptimalGame {
    public static int optimalGame(int arr[], int left, int right) {
        if (right < left)
            return 0;
        int countOfElements = (right - left) + 1;
        if (countOfElements % 2 == 0) {
            int leftSum = arr[left] + optimalGame(arr, left + 1, right);
            int rightSum = arr[right] + optimalGame(arr, left, right - 1);
            return Math.max(leftSum, rightSum);
        }
        return (arr[left] > arr[right]) ? optimalGame(arr, left + 1, right) : optimalGame(arr, left, right - 1);

    }

    public static int optimalGame2(int arr[], int n) {
        int left = n;
        int right = n;
        int[][] dp = new int[left + 1][right + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                int leftVal = arr[i] + (i + 2 > n ? 0 : dp[i + 2][j]) + ((j - 2 < 0 || i + 1 > n) ? 0 : dp[i + 1][j - 2]);
                int rightVal = arr[j] + ((j - 2 < 0) ? 0 : dp[i][j - 2]) + ((i + 2 > n || j - 1 < 0) ? 0 : dp[i + 2][j - 1]);
                dp[i][j] = Math.max(leftVal, rightVal);
            }
        }
        return dp[n][n];
    }

    public static void main(String args[]) {
        String str = "4993 4883 8894 7241 1476 8226 1207 5674 6967 6766 8371 1467 3169 2228 297 288 4300 4194 4689 1155 3934 5209 4342 2916 2808 2067 5467 8012 1855 1894 2684 9266 5705 3578 4775 578 1546 216 395 7883 720 9476";
        int[] arr = Arrays.stream(str.split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();
//        int[] arr = {5, 3, 7, 10};
//        int[] arr = {8, 15, 3, 7};
        int optimalGame = optimalGame(arr, 0, arr.length - 1);
//        int optimalGame2 = optimalGame2(arr, arr.length - 1);
//        System.out.println(optimalGame2);
        System.out.println(optimalGame);
    }
}
