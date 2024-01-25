package com.greenprogrammer.algorithms.list.linkedList;

import com.greenprogrammer.algorithms.constants.AppConstants;
import com.greenprogrammer.algorithms.dto.nodes.LinkedListNode;
import com.greenprogrammer.algorithms.exception.CapacityReachedException;
import com.greenprogrammer.algorithms.list.ListInf;
import lombok.*;

@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Data
public class SinglyLinkedList<T> implements ListInf<T> {
    private LinkedListNode<T> head;
    private int size;
    private int capacity;

    @Override
    public boolean add(T data) throws CapacityReachedException {
        if (this.size == this.capacity)
            throw new CapacityReachedException(AppConstants.CAPACITY_REACHED);
        if (head == null) {
            this.head = new LinkedListNode<>(data, null, null);
        } else {
            LinkedListNode<T> temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(new LinkedListNode<>(data, null, null));
        }
        this.size++;
        return true;
    }

    @Override
    public boolean addLast(T data) {
        return false;
    }

    @Override
    public boolean addFirst(T data) {
        return false;
    }

    @Override
    public boolean addAt(T data, int index) {
        return false;
    }

    @Override
    public boolean modify(T data, int index) {
        return false;
    }

    @Override
    public String view() {
        return null;
    }

    @Override
    public T getFirst() {
        return null;
    }

    @Override
    public T getLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public boolean removeFirst() {
        return false;
    }

    @Override
    public boolean removeLast() {
        return false;
    }

    @Override
    public boolean removeAt(int index) {
        return false;
    }
}
