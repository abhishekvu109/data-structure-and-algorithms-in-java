package com.greenprogrammer.algorithms.service.trees;

import com.greenprogrammer.algorithms.dto.nodes.TreeNode;
import com.greenprogrammer.algorithms.intf.Deque;
import com.greenprogrammer.algorithms.intf.Queue;
import com.greenprogrammer.algorithms.intf.Tree;
import com.greenprogrammer.algorithms.list.linkedList.DoublyLinkedList;

import java.util.LinkedList;
import java.util.List;

public class BreadthFirst {
    public <E extends Comparable<E>> E maximumBfs(TreeNode<E> node) {
        Queue<TreeNode<E>> queue = new DoublyLinkedList<>();
        E maximum = null;
        if (node != null) queue.push(node);
        while (queue.isNotEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode<E> temp = queue.poll();
                if (temp.getLeft() != null) {
                    queue.push(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.push(temp.getRight());
                }
                maximum = maximum == null ? temp.getData() : (temp.getData().compareTo(maximum) > 0 ? temp.getData() : maximum);
            }
        }
        return maximum;
    }

    public <T> int maximumWidthOfABinaryTree(TreeNode<T> node) {
        Queue<TreeNode<T>> queue = new DoublyLinkedList<>();
        int max = 0;
        if (node != null)
            queue.push(node);
        while (queue.isNotEmpty()) {
            max = Math.max(max, queue.size());
            for (int i = 0; i < queue.size(); i++) {
                TreeNode<T> temp = queue.poll();
                if (temp.getLeft() != null) {
                    queue.push(temp.getLeft());
                }
                if (temp.getRight() != null) {
                    queue.push(temp.getRight());
                }
            }
        }
        return max;
    }

    public <T> List<T> treeTraversalInSpiralForm(TreeNode<T> node) {
        Deque<TreeNode<T>> deque = new DoublyLinkedList<>();
        List<T> output = new LinkedList<>();
        if (node != null)
            deque.pushLast(node);
        int level = 1;
        while (deque.isNotEmpty()) {
            for (int i = 0; i < deque.size(); i++) {
                TreeNode<T> temp = (level % 2 == 0) ? deque.pollFirst() : deque.pollLast();
                if (level % 2 == 0) {
                    if (temp.getLeft() != null)
                        deque.pushLast(temp.getLeft());
                    if (temp.getRight() != null)
                        deque.pushLast(temp.getRight());
                } else {
                    if (temp.getRight() != null)
                        deque.pushFirst(temp.getRight());
                    if (temp.getLeft() != null)
                        deque.pushFirst(temp.getLeft());
                }
                output.add(temp.getData());
            }
            output.add(null);
            level += 1;
        }
        return output;
    }
}
