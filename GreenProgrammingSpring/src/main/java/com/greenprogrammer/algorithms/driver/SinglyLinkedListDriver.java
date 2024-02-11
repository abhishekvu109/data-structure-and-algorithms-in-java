package com.greenprogrammer.algorithms.driver;

import com.greenprogrammer.algorithms.list.linkedList.SinglyLinkedList;
import com.greenprogrammer.algorithms.service.list.SinglyLinkedListUtilService;
import com.greenprogrammer.algorithms.service.list.SinglyLinkedListUtilServiceImpl;


public class SinglyLinkedListDriver {

    public void run() {
        SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();
        singlyLinkedList.setCapacity(100);
        SinglyLinkedListUtilService<Integer> service = new SinglyLinkedListUtilServiceImpl<>();
        singlyLinkedList.addLast(10);
        singlyLinkedList.addLast(20);
        singlyLinkedList.addLast(30);
        singlyLinkedList.addLast(40);
        singlyLinkedList.addLast(50);
        singlyLinkedList.addLast(60);
        singlyLinkedList.addLast(70);
        singlyLinkedList.addLast(80);
        singlyLinkedList.addFirst(90);
        singlyLinkedList.addAt(100, 1);
        System.out.println(singlyLinkedList);
        service.reverse(singlyLinkedList);
        System.out.println(singlyLinkedList);
        service.reverseIterative(singlyLinkedList);
        System.out.println(singlyLinkedList);

    }

    public static void main(String[] args) {
        SinglyLinkedListDriver driver = new SinglyLinkedListDriver();
        driver.run();
    }
}
