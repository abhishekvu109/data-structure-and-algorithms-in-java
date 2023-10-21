package com.greenprogrammer.algorithms.linkedlist.node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class SinglyNode<T> {
    private T data;
    private SinglyNode<T> next;

    public SinglyNode(T data) {
        this.data = data;
        this.next = null;
    }
}
