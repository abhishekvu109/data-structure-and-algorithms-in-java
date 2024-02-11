package com.greenprogrammer.algorithms.service.recursion;

import com.greenprogrammer.algorithms.util.ApplicationUtil;

import java.util.LinkedList;
import java.util.List;

public class RecursionServiceImpl implements RecursionService {
    private final RecursionServiceImplUtil recursionServiceImplUtil = new RecursionServiceImplUtil();
    private final ApplicationUtil applicationUtil = new ApplicationUtil();

    @Override
    public String longestPalindromeSubstring(String s) {
        List<String> list = recursionServiceImplUtil.longestPalindromeSubstring(s, 0, -1, "", new LinkedList<>());
        String longestPalindrome = "";
        for (String str : list) {
            if (applicationUtil.isPalindrome(str) && str.length() > longestPalindrome.length())
                longestPalindrome = str;
        }
        return longestPalindrome;
    }
}

class RecursionServiceImplUtil {
    public List<String> longestPalindromeSubstring(String s, int currentIndex, int previousIndex, String subStr, List<String> list) {
        if (currentIndex == s.length()) {
            list.add(subStr);
            return list;
        }
        List<String> exclude = longestPalindromeSubstring(s, currentIndex + 1, currentIndex, subStr, list);
        if (subStr.isEmpty() || previousIndex == currentIndex - 1) {
            subStr += s.charAt(currentIndex);
            return longestPalindromeSubstring(s, currentIndex + 1, currentIndex, subStr, list);
        }
        return list;
    }
}