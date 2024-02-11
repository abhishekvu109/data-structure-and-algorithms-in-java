package com.greenprogrammer.algorithms.service.dp;

public interface DynamicProgrammingServiceSet1<T> {
    public String longestCommonSubsequence(String s1, String s2);

    //    Variation of LCS
    public String shortestCommonSubsequence(String s1, String s2);

//    Variation of LCS

    public int minimumInsertAndDeleteToConvert(String s1, String s2);

//    Variation of LCS

    public long longestPalindromeSubsequence(String s);

//    Variation of LCS

    public long longestRepeatingSubsequence(String s);


    public int coinChangeProblem(int[] coins, int sum);


    public int editDistance(String s1, String s2);

    public int longestIncreasingSubsequence(int[] arr);

    //    Variation of LIS
    public int minimumDeletionsToMakeAnArraySorted(int[] arr);

    //    Variation of LIS
    public int maximumSumIncreasingSubsequence(int[] arr);

    //    Variation of LIS
    public int maximumLengthBitonicSubsequence(int[] arr);

    //    Variation of LIS
    public int buildingBridges(int[] arr);

    //    Variation of LIS
    public int longestChain(int[] arr);

    public int maximumCuts(int n, int a, int b, int c);

    public int minimumCoinsToMakeAValue(int[] coins, int val);

    public int minimumJumpsRequiredToReachTheEnd(int[] arr);

    public long knapsack01(long[] value, long[] weights, long W);

    public int optimalStrategyForAGame(int[] arr);

    public int minimumTrialsRequiredToBreakTheEgg(int eggCount, int numOfFloors);

    /*We are given a key, and we have to count the number of distinct binary search trees
    we can make from the given keys*/
    public int countBSTWithNKeys(int keys);

    public long maximumSumWithNoConsecutives(int[] arr);

    /*
     * Given an array, we have to find out if there exist a subset that adds upto to given sum
     * */
    public boolean subsetSumProblem(int[] arr, int sum);

    public int matrixChainMultiplication(int[] arr);

    public int palindromePartitioning(String s);

    public int allocateMinimumNumberOfPages(int[] arr);
}
