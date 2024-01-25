package com.greenprogrammer.algorithms.heaps;

import java.util.Comparator;

public class MinHeap implements Heap {

    private Integer[] queue;
    private int size;

    private int capacity;

    private Comparator<Integer> comparator;

    private static final int GROWTH_FACTOR = 2;
    private static final int MIN_SIZE = 0;

    public MinHeap() {
        this(5);
    }

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.queue = new Integer[this.capacity];
    }

    @Override
    public void add(Integer item) {
        if (this.size == this.capacity)
            grow(this.capacity * GROWTH_FACTOR);
        this.size++;
        this.queue[size - 1] = item;
        int current = this.size;
        int parent = parent(current);
        while (current != MIN_SIZE && compare(current, parent)) {
            swap(current, parent);
            current = parent;
            parent = parent(current);
        }
    }

    private boolean compare(int current, int parent) {
        return this.queue[current] < this.queue[parent];
    }

    private void grow(int newCapacity) {

    }

    private void swap(int current, int parent) {
        Integer temp = this.queue[current];
        this.queue[current] = this.queue[parent];
        this.queue[parent] = temp;
    }


    @Override
    public int left(int index) {
        return 0;
    }

    @Override
    public int right(int index) {
        return 0;
    }

    @Override
    public int parent(int index) {
        return 0;
    }

    @Override
    public Integer extract() {
        return null;
    }

    @Override
    public void heapify(int index) {

    }
}