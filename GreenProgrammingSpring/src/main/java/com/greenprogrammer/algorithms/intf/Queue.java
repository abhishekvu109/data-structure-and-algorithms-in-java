package com.greenprogrammer.algorithms.intf;

public interface Queue<T> {
    public void push(T data);

    public T poll();

    public T get();

    public int size();

    public boolean isNotEmpty();

    public boolean isEmpty();
}
