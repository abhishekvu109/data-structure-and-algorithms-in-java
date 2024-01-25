package com.greenprogrammer.algorithms.dto.nodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@AllArgsConstructor
@Data
@ToString
@EqualsAndHashCode
public class LinkedListNode<T> {
    private T data;
    private LinkedListNode<T> prev;
    private LinkedListNode<T> next;
}
