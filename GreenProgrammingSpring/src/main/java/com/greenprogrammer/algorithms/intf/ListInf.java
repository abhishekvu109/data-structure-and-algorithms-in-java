package com.greenprogrammer.algorithms.intf;

public interface ListInf<T> extends DataStructure<T> {
    public boolean add(T data);


    public boolean addLast(T data);

    public boolean addFirst(T data);

    public boolean addAt(T data, int index);

    public boolean modify(T data, int index);

    public String view();

    public T getFirst();

    public T getLast();

    public T get(int index);

    public T removeFirst();

    public T removeLast();

    public T removeAt(int index);

    public T remove(T data);

    public boolean contains(T key);

    public boolean isEmpty();

    public boolean isNotEmpty();

    public int size();
}
