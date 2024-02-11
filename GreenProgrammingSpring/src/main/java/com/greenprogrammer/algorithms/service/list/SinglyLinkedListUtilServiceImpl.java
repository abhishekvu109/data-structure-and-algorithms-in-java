package com.greenprogrammer.algorithms.service.list;

import com.greenprogrammer.algorithms.dto.nodes.LinkedListNode;
import com.greenprogrammer.algorithms.list.linkedList.SinglyLinkedList;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
public class SinglyLinkedListUtilServiceImpl<T> implements SinglyLinkedListUtilService<T> {
    @Override
    public LinkedListNode<T> reverse(SinglyLinkedList<T> singlyLinkedList) {
        LinkedListNode<T> newHead = reverseHelper(singlyLinkedList.getHead(), null);
        singlyLinkedList.setHead(newHead);
        return singlyLinkedList.getHead();
    }

    private LinkedListNode<T> reverseHelper(LinkedListNode<T> current, LinkedListNode<T> prev) {
        if (current == null) return prev;
        LinkedListNode<T> next = current.getNext();
        current.setNext(prev);
        prev = current;
        return reverseHelper(next, prev);
    }

    @Override
    public LinkedListNode<T> reverseIterative(SinglyLinkedList<T> singlyLinkedList) {
        LinkedListNode<T> temp = singlyLinkedList.getHead(), prev = null;
        while (temp != null) {
            LinkedListNode<T> next = temp.getNext();
            temp.setNext(prev);
            prev = temp;
            temp = next;
        }
        singlyLinkedList.setHead(prev);
        return prev;
    }

    //TODO: I will do this later
    @Override
    public LinkedListNode<T> reverseInGroups(SinglyLinkedList<T> singlyLinkedList, int groupSize) {
        LinkedListNode<T> temp = singlyLinkedList.getHead();
        LinkedListNode<T> newHead = null, prev = null, groupPrev = singlyLinkedList.getHead();
        while (temp != null) {
            int i = 0;
            while (i < groupSize) {
                LinkedListNode<T> next = temp.getNext();
                temp.setNext(prev);
                prev = temp;
                temp = next;
                i++;
            }
            if (newHead == null) {
                newHead = prev;
            }
            prev = groupPrev;
            groupPrev = temp;
        }
        return null;
    }

    @Override
    public boolean hasLoop(SinglyLinkedList<T> singlyLinkedList) {
        LinkedListNode<T> slow = singlyLinkedList.getHead(), fast = singlyLinkedList.getHead();
        while (fast != null && slow != null) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if (fast == slow) return true;
        }
        return false;
    }

    @Override
    public LinkedListNode<T> intersectionPoint(SinglyLinkedList<T> list1, SinglyLinkedList<T> list2) {
        LinkedListNode<T> head1 = list1.getHead();
        LinkedListNode<T> temp1 = head1;
        LinkedListNode<T> head2 = list2.getHead();
        LinkedListNode<T> temp2 = head2;
        Set<LinkedListNode<T>> container = new HashSet<>();
        while (temp1 != null) {
            container.add(temp1);
            temp1 = temp1.getNext();
        }
        while (temp2 != null) {
            if (container.contains(temp2)) return temp2;
            temp2 = temp2.getNext();
        }
        return null;
    }

    @Override
    public <E extends Comparable<E>> SinglyLinkedList<E> mergeTwoSortedLinkedList(SinglyLinkedList<E> list1, SinglyLinkedList<E> list2) {
        LinkedListNode<E> temp1 = list1.getHead();
        LinkedListNode<E> temp2 = list2.getHead();
        SinglyLinkedList<E> output = new SinglyLinkedList<>();
        while (temp1 != null && temp2 != null) {
            if (temp1.getData().compareTo(temp2.getData()) < 0) {
                output.addLast(temp1.getData());
                temp1 = temp1.getNext();
            } else {
                output.addLast(temp2.getData());
                temp2 = temp2.getNext();
            }
        }
        while (temp1 != null) {
            output.addLast(temp1.getData());
            temp1 = temp1.getNext();
        }
        while (temp2 != null) {
            output.addLast(temp2.getData());
            temp2 = temp2.getNext();
        }
        return output;
    }

    @Override
    public boolean isPalindromeList(SinglyLinkedList<T> list) {
        if (list.isNotEmpty()) {

        }
        return false;
    }
}
