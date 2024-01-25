package com.greenprogrammer.algorithms.string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class AllPossibleSubstrings {
    public static List<String> possibleSubStrings(String s) {
        int size = s.length();
        List<String> output = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            StringBuffer str = new StringBuffer();
            for (int j = i; j < size; j++) {
                output.add(str.append(s.charAt(j)).toString());
            }
        }
        return output;
    }

    public static void printSubstrings(String str, int pivot) {
        if (str.length() == 1 || pivot >= str.length()) {
            System.out.println(str);
        }
        for (int i = 1; i <= str.length(); i++) {
            printSubstrings(str.substring(0, i), i);
            printSubstrings(str.substring(i), i);
        }
    }


    public static void main(String[] args) {
//        System.out.printf("All the possible substrings are: %s", possibleSubStrings("1234"));
//        System.out.printf("\nAll the possible substrings are: %s", printSubstrings("1234"));
        StringBuffer str = new StringBuffer("12345");
        printSubstrings(str.toString(),1);
    }
}
