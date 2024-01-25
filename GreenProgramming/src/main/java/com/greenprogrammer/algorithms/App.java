package com.greenprogrammer.algorithms;

import com.greenprogrammer.algorithms.heaps.Heap;
import com.greenprogrammer.algorithms.heaps.HeapManager;
import com.greenprogrammer.algorithms.util.HeapConstants;

/**
 * Hello world!
 */
public class App {
    public static String longestPalindrome2(String s, int n, String palindrome, int lastIndex) {
        if (n <= 0) {
            return isPalindrome(palindrome) ? palindrome : "";
        }
        String noPick = (lastIndex != -1 && lastIndex != (n + 1)) ? longestPalindrome2(s, n - 1, palindrome, lastIndex) : palindrome;
        String pick = (lastIndex != -1 && lastIndex != (n + 1)) ? longestPalindrome2(s, n - 1, palindrome + s.charAt(n - 1), n - 1) : palindrome;
        if (pick.length() > noPick.length())
            return pick;
        return noPick;
    }

    public static String longestPalindrome(String s) {
        return longestPalindrome2(s, s.length(), "", -1).toString();
    }

    public static boolean isPalindrome(String s) {
        int j = s.length();
        for (int i = 0; i < j; i++) {
            if (s.charAt(i) != s.charAt(j - 1))
                return false;
            j--;
        }
        return true;
    }

    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY;
    }

    public static void main(String[] args) {

//        String str = "baba";
//        String palindrome = longestPalindrome(str);
//        System.out.println(palindrome);
        System.out.println(Day.MONDAY);
        Heap heap = new HeapManager().getHeap(HeapConstants.MIN);
        heap.add(8);
        heap.add(2);
        heap.add(5);
        heap.add(1);
        heap.add(3);
        heap.add(4);
        heap.add(7);
        heap.add(6);

    }
}
