package com.greenprogrammer.algorithms.linkedlist.node;

import lombok.*;

@ToString
@EqualsAndHashCode
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoublyNode<T> {
    private T data;
    private DoublyNode<T> previous;
    private DoublyNode<T> next;
}
