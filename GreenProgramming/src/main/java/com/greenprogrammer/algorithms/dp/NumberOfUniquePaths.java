package com.greenprogrammer.algorithms.dp;

public class NumberOfUniquePaths {
    public static int numberOfUniquePathsRec(int x, int y) {
        if (x == 0 && y == 0)
            return 1;
        else if (y < 0 || x < 0)
            return 0;
        int up = numberOfUniquePathsRec(x - 1, y);
        int down = numberOfUniquePathsRec(x, y - 1);
        return up + down;
    }

    public static int numberOfUniquePathsDp(int x, int y) {
        int dp[][] = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = (i - 1) < 0 ? 0 : dp[i - 1][j];
                int down = (j - 1) < 0 ? 0 : dp[i][j - 1];
                dp[i][j] = up + down;
            }
        }
        return dp[x - 1][y - 1];
    }

    public static void main(String[] args) {
        int x = 3, y = 4;
        int uniquePaths = numberOfUniquePathsRec(x - 1, y - 1);
        int uniquePathsDp = numberOfUniquePathsDp(x, y);
        System.out.printf("\nNumber of unique paths are : %d", uniquePaths);
        System.out.printf("\nNumber of unique paths are : %d", uniquePathsDp);
    }
}
