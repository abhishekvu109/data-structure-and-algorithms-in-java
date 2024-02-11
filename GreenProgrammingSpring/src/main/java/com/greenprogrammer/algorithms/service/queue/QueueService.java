package com.greenprogrammer.algorithms.service.queue;

import com.greenprogrammer.algorithms.intf.ListInf;

public interface QueueService<T> {
    /**
     * @Params :
     * @Param n:Number of output you need
     * @Param digits: Array of digits
     * @Return: List of big integers
     */
    public ListInf<Integer> generateNumbersWithGivenDigits(int n, int[] digits);
}
