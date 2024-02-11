package com.greenprogrammer.algorithms.service.trees;

import com.greenprogrammer.algorithms.constants.TreeTraversalStrategy;
import com.greenprogrammer.algorithms.dto.nodes.TreeNode;
import com.greenprogrammer.algorithms.intf.ListInf;
import com.greenprogrammer.algorithms.intf.Tree;
import com.greenprogrammer.algorithms.list.linkedList.DoublyLinkedList;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

@Component
public class TreeUtilServiceImplHelper {

    private final DepthFirst depthFirst = new DepthFirst();
    private final BreadthFirst breadthFirst = new BreadthFirst();

    public <T> List<T> printNodesAtK(TreeNode<T> node, List<T> output, int k) {
        if (node == null) return output;
        if (k == 1) {
            output.add(node.getData());
            return output;
        }
        List<T> left = printNodesAtK(node.getLeft(), output, k - 1);
        return printNodesAtK(node.getRight(), left, k - 1);
    }

    public <T> List<T> levelOrderLineByLine(TreeNode<T> node) {
        ListInf<TreeNode<T>> queue = new DoublyLinkedList<>();
        List<T> output = new LinkedList<>();
        if (node != null) queue.addLast(node);
        while (queue.isNotEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode<T> temp = queue.removeFirst();
                if (temp.getLeft() != null) queue.addLast(temp.getLeft());
                if (temp.getRight() != null) queue.addLast(temp.getRight());
                output.add(temp.getData());
            }
        }
        return output;
    }

    public <T> List<T> printLeftViewOfBinaryTree(TreeNode<T> node, TreeTraversalStrategy strategy) {
        if (strategy == TreeTraversalStrategy.LEVEL_ORDER) return printLeftViewOfBinaryTreeBfs(node);
        else {
            Map<Integer, TreeMap<Integer, T>> data = printLeftViewOfBinaryTreeDfs(node, new HashMap<Integer, TreeMap<Integer, T>>(), 0, 0);
            return data.entrySet().stream().map(d -> {
                return d.getValue().firstEntry().getValue();
            }).collect(Collectors.toList());
        }
    }

    private <T> List<T> printLeftViewOfBinaryTreeBfs(TreeNode<T> node) {
        ListInf<TreeNode<T>> queue = new DoublyLinkedList<>();
        List<T> aux = new LinkedList<>();
        if (node != null) queue.addLast(node);
        while (queue.isNotEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode<T> temp = queue.removeFirst();
                if (temp.getLeft() != null) queue.addLast(temp.getLeft());
                if (temp.getRight() != null) queue.addLast(temp.getRight());
                aux.add(temp.getData());
            }
        }
        List<T> output = new LinkedList<>();
        T prev = null;
        for (T data : aux) {
            if (prev == null) output.add(data);
            prev = data;
        }
        return output;
    }

    private <T> Map<Integer, TreeMap<Integer, T>> printLeftViewOfBinaryTreeDfs(TreeNode<T> node, Map<Integer, TreeMap<Integer, T>> map, int x, int y) {
        if (node == null) return map;
        TreeMap<Integer, T> data = map.get(y);
        if (data == null || data.isEmpty()) data = new TreeMap<>();
        data.put(x, node.getData());
        map.put(y, data);
        Map<Integer, TreeMap<Integer, T>> left = printLeftViewOfBinaryTreeDfs(node.getLeft(), map, x - 1, y + 1);
        return printLeftViewOfBinaryTreeDfs(node.getRight(), left, x + 1, y + 1);
    }

    public <T> List<T> printRightViewOfBinaryTree(TreeNode<T> node, TreeTraversalStrategy strategy) {
        if (strategy == TreeTraversalStrategy.LEVEL_ORDER) return printLeftViewOfBinaryTreeBfs(node);
        else {
            Map<Integer, TreeMap<Integer, T>> data = printLeftViewOfBinaryTreeDfs(node, new HashMap<Integer, TreeMap<Integer, T>>(), 0, 0);
            return data.entrySet().stream().map(d -> {
                return d.getValue().lastEntry().getValue();
            }).collect(Collectors.toList());
        }
    }

    private <T> List<T> printRightViewOfBinaryTreeBfs(TreeNode<T> node) {
        ListInf<TreeNode<T>> queue = new DoublyLinkedList<>();
        List<T> aux = new LinkedList<>();
        if (node != null) queue.addLast(node);
        while (queue.isNotEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode<T> temp = queue.removeFirst();
                if (temp.getLeft() != null) queue.addLast(temp.getLeft());
                if (temp.getRight() != null) queue.addLast(temp.getRight());
                aux.add(temp.getData());
            }
        }
        List<T> output = new LinkedList<>();
        T prev = null;
        for (T data : aux) {
            if (data == null) output.add(prev);
            prev = data;
        }
        output.add(prev);
        return output;
    }

    public <E extends Number> boolean isChildrenSumProperty(TreeNode<E> node, TreeTraversalStrategy strategy) {
        if (strategy == TreeTraversalStrategy.LEVEL_ORDER) {
            ListInf<TreeNode<E>> queue = new DoublyLinkedList<>();
            if (node != null) queue.addLast(node);
            while (queue.isNotEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode<E> temp = queue.removeFirst();
                    if (temp == null) continue;
                    E left = temp.getLeft() == null ? (E) Double.valueOf(0) : temp.getLeft().getData();
                    E right = temp.getRight() == null ? (E) Double.valueOf(0) : temp.getRight().getData();

                    if (temp.getData().doubleValue() != (left.doubleValue() + right.doubleValue())) return false;
                    if (temp.getLeft() != null) queue.add(temp.getLeft());
                    if (temp.getRight() != null) queue.add(temp.getRight());
                }
            }
            return true;
        } else {
            return isChildrenSumProperty(node);
        }
    }

    private <E extends Number> boolean isChildrenSumProperty(TreeNode<E> node) {
        if (node == null) return true;
        boolean left = isChildrenSumProperty(node.getLeft());
        boolean right = isChildrenSumProperty(node.getRight());
        E nodeLeft = node.getLeft() == null ? (E) Double.valueOf(0) : node.getLeft().getData();
        E nodeRight = node.getRight() == null ? (E) Double.valueOf(0) : node.getRight().getData();
        if (left && right && (node.getData().doubleValue() != (nodeLeft.doubleValue() + nodeRight.doubleValue())))
            return true;
        return false;
    }

    public <T> Map<TreeNode<T>, Integer> isTreeBalanced(TreeNode<T> node, Map<TreeNode<T>, Integer> map) {
        if (node == null) return map;
        Map<TreeNode<T>, Integer> left = isTreeBalanced(node.getLeft(), map);
        Map<TreeNode<T>, Integer> right = isTreeBalanced(node.getLeft(), left);
        int leftH = (node.getLeft() == null) ? 0 : right.get(node.getLeft());
        int rightH = (node.getRight() == null) ? 0 : right.get(node.getRight());
        right.put(node, leftH + rightH + 1);
        return right;
    }

    public <T> TreeNode<T> mirrorTree(TreeNode<T> node) {
        if (node == null) return null;
        TreeNode<T> left = mirrorTree(node.getLeft());
        TreeNode<T> right = mirrorTree(node.getRight());
        node.setLeft(right);
        node.setRight(left);
        return node;
    }

    //TODO: I will do it later.
    public <T> boolean isMirrorTree(TreeNode<T> node1, TreeNode<T> node2, TreeTraversalStrategy strategy) {
        if (strategy == TreeTraversalStrategy.LEVEL_ORDER) {
            ListInf<TreeNode<T>> queue1 = new DoublyLinkedList<>();
            ListInf<TreeNode<T>> queue2 = new DoublyLinkedList<>();
        }
        return false;
    }

    public <E extends Comparable<E>> E maximum(TreeNode<E> node, TreeTraversalStrategy strategy) {
        if (strategy == TreeTraversalStrategy.LEVEL_ORDER) {
            return breadthFirst.maximumBfs(node);
        } else {
            return depthFirst.maximumDfs(node);
        }
    }


    public <T> int verticalWidthOfABinaryTree(TreeNode<T> node, TreeTraversalStrategy strategy) {
        if (strategy == TreeTraversalStrategy.PRE_ORDER || strategy == TreeTraversalStrategy.POST_ORDER || strategy == TreeTraversalStrategy.IN_ORDER) {
            TreeSet<Integer> set = depthFirst.determineVerticalHeightOfATreeMapBuilder(node, new TreeSet<Integer>(), 0);
            if (set != null && !set.isEmpty()) {
                return (set.size() == 1) ? 1 : (set.last() - set.first()) + 1;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public <T> int maximumWidthOfABinaryTree(TreeNode<T> treeNode, TreeTraversalStrategy strategy) {
        if (strategy == TreeTraversalStrategy.IN_ORDER || strategy == TreeTraversalStrategy.PRE_ORDER || strategy == TreeTraversalStrategy.POST_ORDER) {
            Map<Integer, Integer> map = depthFirst.buildMapForMaximumWidthOfABinaryTree(treeNode, new HashMap<>(), 0);
            AtomicInteger max = new AtomicInteger(0);
            map.forEach((key, value) -> max.set(Math.max(max.get(), value)));
            return max.intValue();
        } else {
            return breadthFirst.maximumWidthOfABinaryTree(treeNode);
        }
    }

    public <T> void treeTraversalInSpiralForm(TreeNode<T> node, TreeTraversalStrategy strategy) {
        if (strategy == TreeTraversalStrategy.LEVEL_ORDER) {
            List<T> list = breadthFirst.treeTraversalInSpiralForm(node);
            list.forEach(data -> {
                if (data == null)
                    System.out.println();
                else
                    System.out.print(data + ",");
            });
        } else {
            TreeMap<Integer, TreeMap<Integer, T>> map = depthFirst.treeTraversalInSpiralForm(node, new TreeMap<Integer, TreeMap<Integer, T>>(), 0, 0);
            map.entrySet().forEach(entry -> {
                System.out.println(entry.getValue().values());
            });
        }
    }

}
