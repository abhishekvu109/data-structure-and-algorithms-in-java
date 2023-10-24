package com.greenprogrammer.algorithms.dp;

public class SubSetSumProblem {
    public static int subsetSum(int[] arr, int sum, int n) {
        if (n == 0) {
            return (sum == 0) ? 1 : 0;
        }
//        if (sum == 0)
//            return 1;
//        if (sum < 0)
//            return 0;
        int exclude = subsetSum(arr, sum, n - 1);
        int include = subsetSum(arr, sum - arr[n - 1], n - 1);
        return exclude + include;
    }

    public static int subsetSumDp(int[] arr, int sum, int n) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i < n + 1; i++)
            dp[i][0] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                int exclude = dp[i - 1][j];
                int remaining = j - arr[i - 1];
                int include = ((remaining == 0) ? 1 : 0) + ((remaining < 0) ? 0 : dp[i - 1][j - arr[i - 1]]);
                dp[i][j] = exclude + include;
            }
        }
        return dp[n][sum];
    }

    public static void main(String args[]) {
        String s = "3 82 82 56 96 90 16 90 32 1 27 60 65 22 19 36 17 16 71 31 55 59 28 34 78 44 42 33 52 66 99 6 100 80 61 47 70 76 36 53 28 14 12 44 88 82 31 4 97 2 34 4 12 13 37 89 56 78 22 59 96 72 64 95 52 76 41 73 3 28 25 30 42 89 25 29 22 8 32 19 61 17 74 72 30 10 60 37 40 33 96 87 5 11 33 8 87 25 32 89";
        int[] arr = new int[s.length()];
        String[] c = s.split(" ");
        int i = 0;
        for (String ch : c) {
            arr[i] = Integer.parseInt(ch);
            i++;
        }
//        int[] arr = {1,2,3};
        int n = arr.length;
        int sum = 1155;
//        int subsetProblem = subsetSum(arr, sum, n);
        int subsetProblemDp = subsetSumDp(arr, sum, n);
//        System.out.printf("\nThe output of subset problem = %d", subsetProblem);
        System.out.printf("\nThe output of subset problem = %d", subsetProblemDp);
    }
}
