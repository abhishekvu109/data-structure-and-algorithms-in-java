package com.greenprogrammer.algorithms.list.linkedList.cache;

public interface ListCacheService<T> {
    public T get(T data);

    public void add(T data);
}
