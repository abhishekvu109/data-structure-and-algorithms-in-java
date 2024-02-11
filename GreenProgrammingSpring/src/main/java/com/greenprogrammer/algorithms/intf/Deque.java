package com.greenprogrammer.algorithms.intf;

public interface Deque<T> {
    public void pushFirst(T data);

    public void pushLast(T data);

    public T pollFirst();

    public T pollLast();

    public T getLast();

    public T getFirst();

    public int size();

    public boolean isEmpty();

    public boolean isNotEmpty();
}
