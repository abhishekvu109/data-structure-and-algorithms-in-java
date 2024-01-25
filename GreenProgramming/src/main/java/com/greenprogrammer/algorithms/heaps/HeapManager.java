package com.greenprogrammer.algorithms.heaps;

import com.greenprogrammer.algorithms.util.HeapConstants;

public class HeapManager<T> {
    private Heap heap;

    public Heap getHeap(HeapConstants heapType) {
        if (heapType.equals(HeapConstants.MIN)) {
            heap = new MinHeap();
        } else {
//            heap= new MaxHeap<T>();
            heap = null;
        }
        return heap;
    }
}
