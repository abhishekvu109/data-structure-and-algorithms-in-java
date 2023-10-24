package com.greenprogrammer.algorithms.dp;

public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String s1, String s2, int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1))
            return 1 + longestCommonSubsequence(s1, s2, m - 1, n - 1);
        else
            return Math.max(longestCommonSubsequence(s1, s2, m, n - 1), longestCommonSubsequence(s1, s2, m - 1, n));
    }

    public static int longestCommonSubsequenceDp(String s1, String s2, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String args[]) {
        String s1 = "AGGTAB", s2 = "GXTXAYB";
        System.out.printf("The longest common subsequence is %d", longestCommonSubsequence(s1, s2, s1.length(), s2.length()));
        System.out.printf("\nThe longest common subsequence is %d", longestCommonSubsequenceDp(s1, s2, s1.length(), s2.length()));
    }
}
