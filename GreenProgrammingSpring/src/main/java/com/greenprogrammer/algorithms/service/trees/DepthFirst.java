package com.greenprogrammer.algorithms.service.trees;

import com.greenprogrammer.algorithms.constants.TreeTraversalStrategy;
import com.greenprogrammer.algorithms.dto.nodes.TreeNode;
import com.greenprogrammer.algorithms.intf.Deque;
import com.greenprogrammer.algorithms.intf.ListInf;

import java.util.*;

public class DepthFirst {
    public <T> TreeSet<Integer> determineVerticalHeightOfATreeMapBuilder(TreeNode<T> node, TreeSet<Integer> set, int x) {
        if (node == null) return set;
        TreeSet<Integer> left = determineVerticalHeightOfATreeMapBuilder(node.getLeft(), set, x - 1);
        TreeSet<Integer> right = determineVerticalHeightOfATreeMapBuilder(node.getRight(), left, x + 1);
        right.add(x);
        return right;
    }

    public <E extends Comparable<E>> E maximumDfs(TreeNode<E> node) {
        if (node == null) return null;
        E left = maximumDfs(node.getLeft());
        E right = maximumDfs(node.getRight());
        if (left.compareTo(right) > 0) {
            return (left.compareTo(node.getData()) > 0) ? left : node.getData();
        } else {
            return (right.compareTo(node.getData()) > 0) ? right : node.getData();
        }
    }

    public <T> Map<Integer, Integer> buildMapForMaximumWidthOfABinaryTree(TreeNode<T> node, Map<Integer, Integer> map, int y) {
        if (node == null)
            return map;
        Map<Integer, Integer> left = buildMapForMaximumWidthOfABinaryTree(node.getLeft(), map, y + 1);
        Map<Integer, Integer> right = buildMapForMaximumWidthOfABinaryTree(node.getLeft(), left, y + 1);
        right.merge(y, 1, Integer::sum);
        return right;
    }

    public <T> TreeMap<Integer, TreeMap<Integer, T>> treeTraversalInSpiralForm(TreeNode<T> node, TreeMap<Integer, TreeMap<Integer, T>> map, int x, int y) {
        if (node == null)
            return map;
        TreeMap<Integer, TreeMap<Integer, T>> left = treeTraversalInSpiralForm(node.getLeft(), map, x - 1, y + 1);
        TreeMap<Integer, TreeMap<Integer, T>> right = treeTraversalInSpiralForm(node.getRight(), map, x + 1, y + 1);
        TreeMap<Integer, T> value = map.get(y);
        if (value == null)
            value = (y % 2 != 0) ? new TreeMap<>(((Integer a, Integer b) -> Integer.compare(b, a))) : new TreeMap<>();
        value.put(x, node.getData());
        right.put(y, value);
        return right;
    }

}
