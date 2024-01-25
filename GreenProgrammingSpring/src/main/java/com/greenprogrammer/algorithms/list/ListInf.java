package com.greenprogrammer.algorithms.list;

public interface ListInf<T> {
    public boolean add(T data);

    public boolean addLast(T data);

    public boolean addFirst(T data);

    public boolean addAt(T data, int index);

    public boolean modify(T data, int index);

    public String view();

    public T getFirst();

    public T getLast();

    public T get(int index);

    public boolean removeFirst();

    public boolean removeLast();

    public boolean removeAt(int index);
}
