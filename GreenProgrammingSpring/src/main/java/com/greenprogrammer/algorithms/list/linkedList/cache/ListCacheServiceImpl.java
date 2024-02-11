package com.greenprogrammer.algorithms.list.linkedList.cache;

import com.greenprogrammer.algorithms.constants.AppConstants;
import com.greenprogrammer.algorithms.list.linkedList.DoublyLinkedList;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.Set;

public class ListCacheServiceImpl<T> implements ListCacheService<T> {

    private DoublyLinkedList<T> linkedList;
    private Set<T> set;

    private int size;
    private int capacity;

    public ListCacheServiceImpl(int capacity) {
        this.linkedList = new DoublyLinkedList<>();
        this.set = new HashSet<>();
        this.capacity = capacity;
    }

    public ListCacheServiceImpl() {
        this.linkedList = new DoublyLinkedList<>();
        this.set = new HashSet<>();
        this.capacity = 100;
    }

    @Override
    public T get(T data) {
        if (size == 0)
            throw new EmptyCacheException();
        if (set.contains(data)) {
//            T data= linkedList.re ();
        }
        return null;
    }

    @Override
    public void add(T data) {
        if (this.size >= this.capacity) {
            set.remove(linkedList.getLast());
            linkedList.removeLast();
        }
        this.linkedList.addFirst(data);
        this.set.add(data);
    }
}

class EmptyCacheException extends RuntimeException {
    public EmptyCacheException() {
        super(AppConstants.EMPTY_CACHE_EXCEPTION);
    }
}
