package com.greenprogrammer.algorithms.list.linkedList;

import com.greenprogrammer.algorithms.constants.AppConstants;
import com.greenprogrammer.algorithms.dto.nodes.LinkedListNode;
import com.greenprogrammer.algorithms.exception.CapacityReachedException;
import com.greenprogrammer.algorithms.exception.IndexOutOfBoundException;
import com.greenprogrammer.algorithms.intf.DataStructure;
import com.greenprogrammer.algorithms.intf.Deque;
import com.greenprogrammer.algorithms.intf.ListInf;
import com.greenprogrammer.algorithms.intf.Queue;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
@Data
@Component
public class SinglyLinkedList<T> implements ListInf<T>, Queue<T>, Deque<T> {
    private LinkedListNode<T> head;
    private int size;
    private int capacity;

    @Override
    public boolean add(T data) throws CapacityReachedException {
        if (this.size == this.capacity) throw new CapacityReachedException(AppConstants.CAPACITY_REACHED);
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
        return add(data);
    }

    @Override
    public boolean addFirst(T data) throws CapacityReachedException {
        if (this.size == this.capacity) throw new CapacityReachedException(AppConstants.CAPACITY_REACHED);
        if (this.head == null) this.head = new LinkedListNode<>(data, null, null);
        else this.head = new LinkedListNode<>(data, null, this.head);
        this.size++;
        return true;
    }

    @Override
    public void addAll(T[] data) {
        Arrays.stream(data).forEach(this::add);
    }

    @Override
    public boolean addAt(T data, int index) throws CapacityReachedException, IndexOutOfBoundException {
        if (this.capacity == this.size) throw new CapacityReachedException(AppConstants.CAPACITY_REACHED);
        if (index >= this.size) throw new IndexOutOfBoundException(AppConstants.INDEX_OUT_OF_BOUND);
        if (this.head != null) {
            if (index == 0) return addFirst(data);
            else if (index == this.size - 1) return addLast(data);
            else {
                LinkedListNode<T> temp = this.head.getNext(), prev = this.head, newNode = new LinkedListNode<>(data, null, null);
                int pos = 1;
                while (pos != index) {
                    prev = temp;
                    temp = temp.getNext();
                    pos += 1;
                }
                prev.setNext(newNode);
                newNode.setNext(temp);
                this.size++;
                return true;
            }
        }
        return false;
    }


    @Override
    public boolean modify(T data, int index) {
        if (index >= this.size)
            throw new IndexOutOfBoundException(AppConstants.INDEX_OUT_OF_BOUND);
        if (this.size == this.capacity)
            throw new CapacityReachedException(AppConstants.CAPACITY_REACHED);
        if (this.head != null) {
            int pos = 0;
            LinkedListNode<T> temp = this.head;
            while (pos != index) {
                pos += 1;
                temp = temp.getNext();
            }
            temp.setData(data);
            return true;
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
        LinkedListNode<T> temp = this.head;
        if (temp == null)
            return null;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    @Override
    public T get(int index) {
        if (this.head != null) {
            if (index == 0)
                return getFirst();
            else if (index == this.size)
                return getLast();
            else {
                if (index < 0 && index >= this.size) {
                    return null;
                } else {
                    int pos = 1;
                    LinkedListNode<T> temp = this.head.getNext();
                    while (temp.getNext() != null) {
                        if (pos == index)
                            break;
                        temp = temp.getNext();
                        pos += 1;
                    }
                    return temp.getData();
                }
            }
        }
        return null;
    }

    @Override
    public T removeFirst() {
        if (this.head == null)
            return null;
        else {
            LinkedListNode<T> output = this.head;
            this.head = this.head.getNext();
            this.size -= 1;
            return output.getData();
        }
    }

    @Override
    public T removeLast() {
        if (this.head != null) {
            LinkedListNode<T> temp = this.head, prev = null;
            while (temp.getNext() != null) {
                prev = temp;
                temp = temp.getNext();
            }
            if (prev == null)
                return temp.getData();
            else {
                prev.setNext(null);
                this.size -= 1;
                return temp.getData();
            }
        }
        return null;
    }

    @Override
    public T removeAt(int index) {
        if (this.head != null) {
            if (index == 0)
                return removeFirst();
            else if (index == this.size)
                return removeLast();
            else {
                int pos = 0;
                LinkedListNode<T> temp = this.head.getNext(), prev = this.head, output;
                while (temp.getNext() != null) {
                    prev = temp;
                    temp = temp.getNext();
                    pos += 1;
                    if (pos == index)
                        break;
                }
                prev.setNext(temp.getNext());
                return temp.getData();
            }
        }
        return null;
    }

    @Override
    public T remove(T data) {
        if (this.size == 0 && this.head == null)
            return null;
        LinkedListNode<T> temp = this.head;
        while (temp != null) {
            if (data.equals(temp.getData())) {
                temp.getPrev().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrev());
                this.size--;
                return temp.getData();
            }
            temp = temp.getNext();
        }
        return null;
    }

    @Override
    public boolean contains(T key) {
        LinkedListNode<T> temp = this.head;
        while (temp != null) {
            if (key.equals(temp.getData()))
                return true;
            temp = temp.getNext();
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer output = new StringBuffer();
        LinkedListNode<T> temp = this.head;
        while (temp != null) {
            output.append(temp.getData());
            output.append(",");
            temp = temp.getNext();
        }
        if (output.length() > 0)
            output.deleteCharAt(output.length() - 1);
        output.insert(0, '[');
        output.append(']');
        return output.toString();
    }

    @Override
    public boolean isEmpty() {
        return (this.size == 0);
    }

    @Override
    public boolean isNotEmpty() {
        return this.size > 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void pushFirst(T data) {
        this.addFirst(data);
    }

    @Override
    public void pushLast(T data) {
        this.addLast(data);
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
        add(data);
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
