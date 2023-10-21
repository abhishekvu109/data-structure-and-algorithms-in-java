package com.greenprogrammer.algorithms.greedy;

import com.greenprogrammer.algorithms.util.Pair;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ActivitySelection {
    public static int getNumberOfActivities(int start[], int end[], int n) {
        int count = 0;
        List<Pair<Integer, Integer>> list = new LinkedList<>();
        for (int i = 0; i < n; i++)
            list.add(new Pair<Integer, Integer>(start[i], end[i]));
        List<Pair<Integer, Integer>> sortedList = list.stream().sorted((a, b) -> {
            return a.getValue().compareTo(b.getValue());
        }).collect(Collectors.toList());
        Pair<Integer, Integer> prev = null;
        for (Pair<Integer, Integer> current : sortedList) {
            if ((count == 0) || (current.getKey() > prev.getKey() && current.getKey() < prev.getValue())) {
                count++;
                prev = current;
            }
        }
        return count;
    }

    public static int getNumberOfActivities2(int start[], int end[], int n) {
        int count = 0;
        List<Pair<Integer, Integer>> sortedList = new LinkedList<>();
        for (int i = 0; i < n; i++)
            sortedList.add(new Pair<Integer, Integer>(start[i], end[i]));
        Collections.sort(sortedList, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        Pair<Integer, Integer> prev = null;
        for (Pair<Integer, Integer> current : sortedList) {
            if ((count == 0) || (current.getKey() > prev.getValue())) {
                count++;
                prev = current;
            }
        }
        return count;
    }

    public static void main(String args[]) {
        int[] start = {1, 3, 2, 5};
        int[] end = {2, 4, 3, 6};
        System.out.printf("The the total number of activities can be %d", getNumberOfActivities2(start, end, start.length));
    }
}
