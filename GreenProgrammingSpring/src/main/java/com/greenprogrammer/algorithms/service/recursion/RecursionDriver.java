package com.greenprogrammer.algorithms.service.recursion;

public class RecursionDriver {
    public static void main(String[] args) {
        RecursionService recursionService = new RecursionServiceImpl();
        String longestPalindromeSubString = recursionService.longestPalindromeSubstring("babad");
        System.out.println(longestPalindromeSubString);
    }
}
