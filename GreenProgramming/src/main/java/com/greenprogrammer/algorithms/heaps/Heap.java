package com.greenprogrammer.algorithms.heaps;

//public interface Heap<T> {
//    public void add(T item);
//
//    public int left(int index);
//
//    public int right(int index);
//
//    public int parent(int index);
//
//    public T extract();
//
//    public void heapify(int index);
//}
public interface Heap {
    public void add(Integer item);

    public int left(int index);

    public int right(int index);

    public int parent(int index);

    public Integer extract();

    public void heapify(int index);
}
