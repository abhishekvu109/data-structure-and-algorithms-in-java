package com.greenprogrammer.algorithms.tree;

import com.greenprogrammer.algorithms.constants.TreeStrategy;
import com.greenprogrammer.algorithms.constants.TreeTraversalStrategy;
import com.greenprogrammer.algorithms.dto.nodes.TreeNode;
import com.greenprogrammer.algorithms.intf.ListInf;
import com.greenprogrammer.algorithms.intf.Tree;
import com.greenprogrammer.algorithms.list.linkedList.DoublyLinkedList;
import com.sun.source.tree.DoWhileLoopTree;

public class BinaryTree<T> implements Tree<T> {
    private TreeNode<T> root;
    private int size;

    @Override
    public void addAll(T[] data) {

    }

    @Override
    public T add(T data, TreeStrategy strategy) {
        if (strategy == TreeStrategy.DFS) {
        }
//            addViaDfs();
        else addViaBfs(data);
        return null;
    }

    //TODO: The logic to finish this method is tricky
    private <E extends Comparable<E>> void addViaDfs(E data) {
        if (getRoot() == null) {
        }
    }

    private void addViaBfs(T data) {
        if (getRoot() == null) {
            this.root = new TreeNode<T>(data, null, null);
            this.size++;
        } else {
            ListInf<TreeNode<T>> queue = new DoublyLinkedList<>();
            queue.addLast(getRoot());
            while (queue.isNotEmpty()) {
                for (int i = 0; i < queue.size(); i++) {
                    TreeNode<T> temp = queue.removeFirst();
                    if (temp.getLeft() == null) {
                        temp.setLeft(new TreeNode<>(data, null, null));
                        this.size++;
                        return;
                    }
                    if (temp.getRight() == null) {
                        temp.setRight(new TreeNode<>(data, null, null));
                        this.size++;
                        return;
                    }
                    queue.addLast(temp.getLeft());
                    queue.addLast(temp.getRight());
                }
            }
        }
    }

    @Override
    public ListInf<T> traverse(TreeTraversalStrategy strategy) {
        ListInf<T> output = new DoublyLinkedList<>();
        if (strategy == TreeTraversalStrategy.IN_ORDER)
            output = traverseInOrder(getRoot(), output);
        else if (strategy == TreeTraversalStrategy.PRE_ORDER)
            output = traversePreOrder(getRoot(), output);
        else if (strategy == TreeTraversalStrategy.POST_ORDER)
            output = traversePostOrder(getRoot(), output);
        else if (strategy == TreeTraversalStrategy.LEVEL_ORDER)
            output = traverseLevelOrder();
        return output;
    }

    private ListInf<T> traverseInOrder(TreeNode<T> node, ListInf<T> output) {
        if (node == null) return output;
        ListInf<T> left = traverseInOrder(node.getLeft(), output);
        left.addLast(node.getData());
        return traverseInOrder(node.getRight(), left);
    }

    private ListInf<T> traversePreOrder(TreeNode<T> node, ListInf<T> output) {
        if (node == null) return output;
        output.addLast(node.getData());
        ListInf<T> left = traversePreOrder(node.getLeft(), output);
        return traversePreOrder(node.getRight(), left);
    }

    private ListInf<T> traversePostOrder(TreeNode<T> node, ListInf<T> output) {
        if (node == null) return output;
        ListInf<T> left = traversePostOrder(node.getLeft(), output);
        ListInf<T> right = traversePostOrder(node.getRight(), left);
        right.addLast(node.getData());
        return right;
    }

    private ListInf<T> traverseLevelOrder() {
        ListInf<T> output = new DoublyLinkedList<>();
        ListInf<TreeNode<T>> queue = new DoublyLinkedList<>();
        if (getRoot() == null) queue.addLast(getRoot());
        while (queue.isNotEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode<T> temp = queue.removeFirst();
                if (temp.getLeft() != null) queue.addLast(temp.getLeft());
                if (temp.getRight() != null) queue.addLast(temp.getRight());
                output.addLast(temp.getData());
            }
        }
        return output;
    }

    @Override
    public int height(TreeTraversalStrategy strategy) {
        return 0;
    }

    private int height(TreeNode<T> node) {
        if (node == null)
            return 0;
        return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
    }

    private int height() {
        ListInf<T> output = new DoublyLinkedList<>();
        ListInf<TreeNode<T>> queue = new DoublyLinkedList<>();
        if (getRoot() == null) queue.addLast(getRoot());
        int height = 0;
        while (queue.isNotEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode<T> temp = queue.removeFirst();
                if (temp.getLeft() != null) queue.addLast(temp.getLeft());
                if (temp.getRight() != null) queue.addLast(temp.getRight());
                output.addLast(temp.getData());
            }
            height++;
        }
        return height;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public int diameter() {
        return 0;
    }

    @Override
    public TreeNode<T> getRoot() {
        return this.root;
    }

    @Override
    public void setRoot(TreeNode<T> root) {
        this.root = root;
    }
}
