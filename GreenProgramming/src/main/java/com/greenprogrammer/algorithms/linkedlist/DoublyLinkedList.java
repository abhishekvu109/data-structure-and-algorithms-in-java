package com.greenprogrammer.algorithms.linkedlist;

import com.greenprogrammer.algorithms.exceptions.linkedlist.IndexOutOfRangeException;
import com.greenprogrammer.algorithms.linkedlist.node.DoublyNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class DoublyLinkedList<T> {
    private DoublyNode<T> head;
    private int length;

    private int size() {
        return this.length;
    }

    public void addFirst(T data) {
        if (this.head == null)
            this.head = new DoublyNode<T>(data, null, null);
        else {
            DoublyNode<T> newNode = new DoublyNode<>(data, null, this.head);
            this.head.setPrevious(newNode);
            this.head = newNode;
        }
        this.length++;
    }

    public void addLast(T data) {
        if (this.head == null)
            this.head = new DoublyNode<T>(data, null, null);
        else {
            DoublyNode<T> newNode = new DoublyNode<>(data, null, null);
            DoublyNode<T> temp = this.head;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            newNode.setPrevious(temp);
        }
        this.length++;
    }

    public void addAt(T data, int index) {
        if (index > this.length)
            throw new IndexOutOfRangeException("Index is out of range");
        if (this.head == null && index == 0)
            this.head = new DoublyNode<T>(data, null, null);
        else {
            int count = 0;
            DoublyNode<T> temp = this.head;
            while (temp != null && count + 1 != index) {
                temp = temp.getNext();
            }
            DoublyNode<T> newNode = new DoublyNode<>(data, temp, temp.getNext());
            if (temp.getNext() != null)
                temp.getNext().setPrevious(newNode);
            temp.setNext(newNode);
        }
        this.length++;
    }

    public T removeFirst() {
        return null;
    }

    public T removeLast() {
        return null;
    }

    public T removeAt() {
        return null;
    }

    public void replace(T data, int index) {

    }

    public T getFirst() {
        return null;
    }

    public T getLast() {
        return null;
    }

    public T getAt(int index) {
        return null;
    }


    @Override
    public String toString() {
        StringBuilder output = new StringBuilder("");
        return output.toString();
    }
}
