package com.greenprogrammer.algorithms.service.list;

import com.greenprogrammer.algorithms.dto.nodes.LinkedListNode;
import com.greenprogrammer.algorithms.list.linkedList.SinglyLinkedList;
import org.springframework.stereotype.Service;

@Service
public interface SinglyLinkedListUtilService<T> {
    public LinkedListNode<T> reverse(SinglyLinkedList<T> singlyLinkedList);

    public LinkedListNode<T> reverseIterative(SinglyLinkedList<T> singlyLinkedList);

    public LinkedListNode<T> reverseInGroups(SinglyLinkedList<T> singlyLinkedList, int groupSize);

    public boolean hasLoop(SinglyLinkedList<T> singlyLinkedList);

    public LinkedListNode<T> intersectionPoint(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2);

    public <E extends Comparable<E>> SinglyLinkedList<E> mergeTwoSortedLinkedList(SinglyLinkedList<E> list1, SinglyLinkedList<E> list2);

    public boolean isPalindromeList(SinglyLinkedList<T> list);
}
