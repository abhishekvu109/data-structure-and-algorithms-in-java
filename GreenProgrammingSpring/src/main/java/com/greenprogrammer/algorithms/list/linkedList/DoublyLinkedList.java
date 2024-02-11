package com.greenprogrammer.algorithms.list.linkedList;

import com.greenprogrammer.algorithms.constants.AppConstants;
import com.greenprogrammer.algorithms.dto.nodes.LinkedListNode;
import com.greenprogrammer.algorithms.exception.CapacityReachedException;
import com.greenprogrammer.algorithms.exception.IndexOutOfBoundException;
import com.greenprogrammer.algorithms.intf.Deque;
import com.greenprogrammer.algorithms.intf.ListInf;
import com.greenprogrammer.algorithms.intf.Queue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DoublyLinkedList<T> implements ListInf<T>, Deque<T>, Queue<T> {

    private LinkedListNode<T> head;
    private LinkedListNode<T> tail;
    private int size;
    //    If the capacity is -1 then the List keeps growing linearly
    private int capacity = AppConstants.DEFAULT_CAPACITY;


    @Override
    public boolean add(T data) throws CapacityReachedException {
        if (this.capacity != AppConstants.DEFAULT_CAPACITY && this.size == this.capacity)
            throw new CapacityReachedException(AppConstants.CAPACITY_REACHED);
        return addLast(data);
    }

    @Override
    public boolean addLast(T data) {
        if (this.capacity != AppConstants.DEFAULT_CAPACITY && this.size == this.capacity)
            throw new CapacityReachedException(AppConstants.CAPACITY_REACHED);
        LinkedListNode<T> newNode = new LinkedListNode<>(data, null, null);
        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            if (this.head == this.tail) {
                this.head.setNext(newNode);
                newNode.setPrev(this.head);
            } else {
                tail.setNext(newNode);
                newNode.setPrev(this.tail);
            }
            this.tail = newNode;
            this.size++;
        }
        return true;
    }

    @Override
    public boolean addFirst(T data) {
        if (this.capacity != AppConstants.DEFAULT_CAPACITY && this.size == this.capacity)
            throw new CapacityReachedException(AppConstants.CAPACITY_REACHED);
        LinkedListNode<T> newNode = new LinkedListNode<>(data, null, null);
        if (this.head == null) {
            this.head = newNode;
            this.tail = this.head;
        } else {
            if (this.head == this.tail)
                newNode.setNext(this.tail);
            else
                newNode.setNext(this.head);
            this.head = newNode;
            this.size++;
        }
        return true;
    }

    @Override
    public boolean addAt(T data, int index) {
        if (this.capacity != AppConstants.DEFAULT_CAPACITY && this.size == this.capacity)
            throw new CapacityReachedException(AppConstants.CAPACITY_REACHED);
        if (index > this.size)
            throw new IndexOutOfBoundException(AppConstants.INDEX_OUT_OF_BOUND);
        if (index == 0)
            return addFirst(data);
        else if (index == size)
            return addLast(data);
        else {
            LinkedListNode<T> newNode = new LinkedListNode<>(data, null, null);
            if (index == 1) {
                newNode.setNext(this.head.getNext());
                newNode.setPrev(this.head);
            } else if (index == size - 1) {
                newNode.setPrev(this.tail.getPrev());
                this.tail.getPrev().setNext(newNode);
                newNode.setNext(this.tail);
                this.tail.setPrev(newNode);
            } else {
                int pos = 2;
                LinkedListNode<T> temp = this.head.getNext().getNext();
                while (pos <= this.size - 2) {
                    if (pos == index) {
                        temp.getPrev().setNext(newNode);
                        newNode.setPrev(temp.getPrev());
                        newNode.setNext(temp.getNext());
                        temp.getNext().setPrev(newNode);
                        this.size++;
                        return true;
                    }
                    temp = temp.getNext();
                    pos += 1;
                }
            }
            this.size++;
        }
        return false;
    }

    @Override
    public boolean modify(T data, int index) {
        if (index >= this.size)
            throw new IndexOutOfBoundException(AppConstants.INDEX_OUT_OF_BOUND);
        LinkedListNode<T> temp = this.head;
        int pos = 0;
        while (temp != null && pos < this.size) {
            if (pos == index) {
                temp.setData(data);
                return false;
            }
            temp = temp.getNext();
            pos += 1;
        }
        return false;
    }

    @Override
    public String view() {
        StringBuilder output = new StringBuilder();
        output.append('[');
        LinkedListNode<T> temp = this.head;
        while (temp != null) {
            output.append(temp);
            output.append(',');
            temp = temp.getNext();
        }
        output.deleteCharAt(output.length() - 1);
        output.append(']');
        return output.toString();
    }

    @Override
    public T getFirst() {
        return (this.head == null) ? null : this.head.getData();
    }

    @Override
    public T getLast() {
        return (this.tail == null) ? null : this.tail.getData();
    }

    @Override
    public T get(int index) {
        if (index >= this.size)
            throw new IndexOutOfBoundException(AppConstants.INDEX_OUT_OF_BOUND);
        int pos = 0;
        LinkedListNode<T> temp = this.head;
        while (temp != null && pos < this.size) {
            if (pos == index) {
                return temp.getData();
            }
            pos += 1;
            temp = temp.getNext();
        }
        return null;
    }

    @Override
    public T removeFirst() {
        if (this.head == null)
            return null;
        LinkedListNode<T> first = this.head;
        this.head = this.head.getNext();
        this.size--;
        return first.getData();
    }

    @Override
    public T removeLast() {
        if (this.tail == null)
            return null;
        LinkedListNode<T> last = this.tail;
        this.tail = this.tail.getPrev();
        this.size--;
        return (this.tail == null) ? null : last.getData();
    }

    @Override
    public T removeAt(int index) {
        if (index >= this.size)
            throw new IndexOutOfBoundException(AppConstants.INDEX_OUT_OF_BOUND);
        if (index == 0)
            return removeFirst();
        else if (index == this.size - 1)
            return removeLast();
        else {
            LinkedListNode<T> temp = this.getHead().getNext();
            int pos = 1;
            while (temp != null && pos <= this.size - 2) {
                if (pos == index) {
                    temp.getPrev().setNext(temp.getNext());
                    temp.getNext().setPrev(temp.getPrev());
                    this.size--;
                    return temp.getData();
                }
                temp = temp.getNext();
                pos += 1;
            }
        }
        return null;
    }

    @Override
    public boolean contains(T key) {
        if (this.head == null)
            return false;
        LinkedListNode<T> temp = this.getHead();
        while (temp != null) {
            if (temp.getData().equals(key))
                return true;
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return (this.head == null || this.size == 0);
    }

    @Override
    public boolean isNotEmpty() {
        return !this.isEmpty();
    }

    @Override
    public void addAll(T[] data) {

    }

    @Override
    public T remove(T data) {
        return null;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void pushFirst(T data) {
        addFirst(data);
    }

    @Override
    public void pushLast(T data) {
        addLast(data);
    }

    @Override
    public T pollFirst() {
        return removeFirst();
    }

    @Override
    public T pollLast() {
        return removeLast();
    }

    @Override
    public void push(T data) {
        addLast(data);
    }

    @Override
    public T poll() {
        return removeFirst();
    }

    @Override
    public T get() {
        return getFirst();
    }
}
