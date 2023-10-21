package com.greenprogrammer.algorithms.linkedlist;

import com.greenprogrammer.algorithms.exceptions.linkedlist.ElementNotExistInIndex;
import com.greenprogrammer.algorithms.exceptions.linkedlist.IndexOutOfRangeException;
import com.greenprogrammer.algorithms.linkedlist.node.SinglyNode;
import lombok.*;

@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class SinglyLinkedList<T> {
    private SinglyNode<T> head;
    private int length;

    public void addLast(T data) {
        if (this.head == null)
            this.head = new SinglyNode<T>(data);
        else {
            SinglyNode<T> temp = this.head;
            while (temp.getNext() != null)
                temp = temp.getNext();
            temp.setNext(new SinglyNode<T>(data));
        }
        this.length++;
    }

    public void addFirst(T data) {
        if (this.head == null)
            this.head = new SinglyNode<T>(data);
        else {
            SinglyNode<T> newNode = new SinglyNode<T>(data);
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.length++;
    }

    public void addAt(T data, int index) {
        if (index > this.length)
            throw new ElementNotExistInIndex("The length of the array is less than the given index");
        if (index == 0) {
            SinglyNode<T> newNode = new SinglyNode<T>(data);
            newNode.setNext(this.head);
            this.head = newNode;

        } else {
            int current = 0;
            SinglyNode<T> temp = this.head;
            if ((temp != null && current + 1 != index)) {
                temp = temp.getNext();
                current++;
            }
            SinglyNode<T> newNode = new SinglyNode<>(data, temp.getNext());
            temp.setNext(newNode);
            this.length++;
        }
        this.length++;
    }

    public T getFirst() {
        if (this.head == null)
            return null;
        return this.head.getData();
    }

    public T getLast() {
        if (this.head == null)
            return null;
        SinglyNode<T> temp = this.head;
        while (temp.getNext() != null) {
            temp = temp.getNext();
        }
        return temp.getData();
    }

    public T get(int index) {
        if (this.head == null)
            return null;
        if (index > this.length)
            throw new IndexOutOfRangeException("Index out of range exception");
        SinglyNode<T> temp = this.head;
        int count = 0;
        while (temp.getNext() != null && count != index) {
            temp = temp.getNext();
            count++;
        }
        return temp.getData();
    }

    private SinglyNode<T> reverse(SinglyNode<T> node) {
        if (node.getNext() == null) {
            this.head = node;
            return node;
        }
        SinglyNode<T> next = reverse(node.getNext());
        next.setNext(node);
        node.setNext(null);
        return node;
    }

    public void reverse() {
        this.reverse(this.head);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        if (this.head != null) {
            SinglyNode<T> node = this.head;
            while (node != null) {
                output.append(node.getData()).append(",");
                node = node.getNext();
            }
            output.deleteCharAt(output.length() - 1);
        }
        return String.format("%s%s%s", "[", output.toString(), "]");
    }

    public static void main(String args[]) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.addLast(50);
        list.addLast(60);
        list.addLast(70);
        System.out.println(list);
        list.reverse();
        System.out.println(list);
    }

}
