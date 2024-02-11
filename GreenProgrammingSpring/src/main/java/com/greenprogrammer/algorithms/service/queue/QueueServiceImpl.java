package com.greenprogrammer.algorithms.service.queue;

import com.greenprogrammer.algorithms.intf.ListInf;
import com.greenprogrammer.algorithms.intf.Queue;
import com.greenprogrammer.algorithms.list.linkedList.DoublyLinkedList;

public class QueueServiceImpl<T> implements QueueService<T> {
    @Override
    public ListInf<Integer> generateNumbersWithGivenDigits(int n, int[] digits) {
        Queue<Integer> queue = new DoublyLinkedList<>();
        ListInf<Integer> output = new DoublyLinkedList<>();
        int count = 0;
        int size = digits.length;
        for (int i = 0; i < size; i++)
            queue.push(digits[i]);
        while (count <= n) {
            Integer i = queue.poll();
            output.addLast(i);
            count++;
            for (int j = 0; j < size; j++)
                queue.push(digits[j]);
        }
        return output;
    }
}
