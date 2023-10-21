package com.greenprogrammer.algorithms.tree;

import com.greenprogrammer.algorithms.tree.node.TreeNode;
import com.greenprogrammer.algorithms.util.Pair;
import lombok.*;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;

import java.util.*;

@EqualsAndHashCode
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor

public class BinaryTree<T> {
    private TreeNode<T> root;

    public void add(T data) {
        if (this.root == null) {
            this.root = new TreeNode<>(data, null, null);
            return;
        }
        Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
        queue.offer(this.root);
        while (CollectionUtils.isNotEmpty(queue)) {
            TreeNode<T> aux = queue.poll();
            if (aux.getData().hashCode() >= data.hashCode()) {
                if (aux.getLeft() != null) {
                    queue.offer(aux.getLeft());
                } else {
                    aux.setLeft(new TreeNode<T>(data));
                    return;
                }
            } else {
                if (aux.getRight() != null) {
                    queue.offer(aux.getRight());
                } else {
                    aux.setRight(new TreeNode<T>(data));
                    return;
                }
            }
        }
    }

    public List<T> levelOrderTraversal() {
        List<T> output = new LinkedList<>();
        if (this.root != null) {
            Queue<TreeNode<T>> queue = new LinkedList<TreeNode<T>>();
            queue.offer(this.root);
            while (CollectionUtils.isNotEmpty(queue)) {
                TreeNode<T> aux = queue.poll();
                if (aux != null)
                    output.add(aux.getData());
                if (aux != null && aux.getLeft() != null)
                    queue.offer(aux.getLeft());
                if (aux != null && aux.getRight() != null)
                    queue.offer(aux.getRight());
            }
        }
        return output;
    }

    private List<T> preOrderUtil(TreeNode<T> node, List<T> container) {
        if (node == null)
            return container;
        container.add(node.getData());
        List<T> left = preOrderUtil(node.getLeft(), container);
        List<T> right = preOrderUtil(node.getRight(), left);
        return right;
    }

    public List<T> preOrder() {
        return preOrderUtil(this.root, new LinkedList<T>());
    }

    private List<T> inOrderUtil(TreeNode<T> node, List<T> container) {
        if (node == null)
            return container;
        List<T> left = inOrderUtil(node.getLeft(), container);
        left.add(node.getData());
        List<T> right = inOrderUtil(node.getRight(), left);
        return right;
    }

    public List<T> inOrder() {
        return inOrderUtil(this.root, new LinkedList<T>());
    }

    private List<T> postOrderUtil(TreeNode<T> node, List<T> container) {
        if (node == null)
            return container;
        List<T> left = postOrderUtil(node.getLeft(), container);
        List<T> right = postOrderUtil(node.getRight(), left);
        right.add(node.getData());
        return right;
    }

    public List<T> postOrder() {
        return postOrderUtil(this.root, new LinkedList<T>());
    }

    public void printLineByLine() {
        List<T> output = new LinkedList<>();
        if (this.root != null) {
            Queue<TreeNode<T>> queue = new LinkedList<>();
            queue.offer(this.root);
            while (CollectionUtils.isNotEmpty(queue)) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode<T> aux = queue.poll();
                    if (aux == null)
                        continue;
                    if (aux.getLeft() != null)
                        queue.offer(aux.getLeft());
                    if (aux.getRight() != null)
                        queue.offer(aux.getRight());
                    output.add(aux.getData());
                }
                output.add(null);
            }
            if (CollectionUtils.isNotEmpty(output)) {
                for (T item : output) {
                    if (item == null) {
                        System.out.println();
                    } else {
                        System.out.print(item + ",");
                    }
                }
            }
        }
    }

    private int sizeUtil(TreeNode<T> node) {
        if (node == null)
            return 0;
        return 1 + sizeUtil(node.getLeft()) + sizeUtil(node.getRight());
    }

    public int size() {
        return sizeUtil(this.root);
    }

    private Integer getMaxUtil(TreeNode<Integer> node) {
        if (node == null)
            return Integer.MIN_VALUE;
        Integer left = getMaxUtil(node.getLeft());
        Integer right = getMaxUtil(node.getRight());
        return Integer.max(Integer.max(left, right), node.getData());
    }

    public Integer getMax(TreeNode<Integer> node) {
        return getMaxUtil(node);
    }

    private int heightUtil(TreeNode<T> node) {
        if (node == null)
            return 0;
        return Math.max(heightUtil(node.getLeft()), heightUtil(node.getRight())) + 1;
    }

    public int height() {
        return heightUtil(this.root);
    }

    public List<T> itemsAtDistanceK(int k) {
        List<T> output = new LinkedList<>();
        List<T> finalOutput = new LinkedList<>();
        if (this.root != null) {
            Queue<TreeNode<T>> queue = new LinkedList<>();
            queue.offer(this.root);
            while (CollectionUtils.isNotEmpty(queue)) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode<T> aux = queue.poll();
                    if (aux == null)
                        continue;
                    if (aux.getLeft() != null)
                        queue.offer(aux.getLeft());
                    if (aux.getRight() != null)
                        queue.offer(aux.getRight());
                    output.add(aux.getData());
                }
                output.add(null);
            }
            int level = 1;
            if (CollectionUtils.isNotEmpty(output)) {
                for (T item : output) {
                    if (item == null) {
                        level++;
                    } else if (level == k) {
                        finalOutput.add(item);
                    }
                }
            }
        }
        return finalOutput;
    }

    private List<T> getItemsAtDistanceKUtil(TreeNode<T> node, int k, List<T> output) {
        if (node == null)
            return output;
        List<T> left = getItemsAtDistanceKUtil(node.getLeft(), k - 1, output);
        List<T> right = getItemsAtDistanceKUtil(node.getRight(), k - 1, left);
        if (k == 1)
            right.add(node.getData());
        return right;
    }

    public List<T> getItemsAtDistanceK(int k) {
        return getItemsAtDistanceKUtil(this.root, k, new LinkedList<T>());
    }

    private TreeMap<Integer, Pair<Integer, T>> printLeftViewUtil(TreeNode<T> node, Integer x, Integer y, TreeMap<Integer, Pair<Integer, T>> treeMap) {
        if (node == null)
            return treeMap;
        TreeMap<Integer, Pair<Integer, T>> left = printLeftViewUtil(node.getLeft(), x - 1, y + 1, treeMap);
        TreeMap<Integer, Pair<Integer, T>> right = printLeftViewUtil(node.getRight(), x + 1, y + 1, left);
        if (right.get(y) == null) {
            right.put(y, new Pair<Integer, T>(x, node.getData()));
        } else {
            Pair<Integer, T> currentVal = right.get(y);
            if (currentVal.getKey() > x) {
                right.put(y, new Pair<Integer, T>(x, node.getData()));
            }
        }
        return right;
    }

    public List<T> printLeftView() {
        List<T> list = new LinkedList<>();
        if (this.root != null) {
            TreeMap<Integer, Pair<Integer, T>> treeMap = printLeftViewUtil(this.root, 0, 0, new TreeMap<Integer, Pair<Integer, T>>());
            for (Map.Entry<Integer, Pair<Integer, T>> entry : treeMap.entrySet()) {
                Pair<Integer, T> pair = entry.getValue();
                list.add(pair.getValue());
            }
        }
        return list;
    }

    private Pair<Boolean, Integer> childrenSumPropertyUtil(TreeNode<Integer> node, Pair<Boolean, Integer> pair) {

        if (node == null) {
            return new Pair<>(true, 0);
        }
        Pair<Boolean, Integer> left = childrenSumPropertyUtil(node.getLeft(), pair);
        Pair<Boolean, Integer> right = childrenSumPropertyUtil(node.getRight(), pair);
        if (left.getKey() && right.getKey()) {
            Integer total = left.getValue() + right.getValue();
            if (total == 0 || total.equals(node.getData()))
                return new Pair<>(true, node.getData());
        }
        return new Pair<>(false, node.getData());

    }

    public boolean childrenSumProperty(TreeNode<Integer> node) {
        return childrenSumPropertyUtil(node, new Pair<>(false, 0)).getKey();
    }

    private Pair<Boolean, Integer> isBalancedUtil(TreeNode<T> node, Integer level, Pair<Boolean, Integer> pair) {
        if (node == null) {
            return new Pair<>(true, level - 1);
        }
        Pair<Boolean, Integer> left = isBalancedUtil(node.getLeft(), level + 1, pair);
        Pair<Boolean, Integer> right = isBalancedUtil(node.getRight(), level + 1, left);
        if (left.getKey() && right.getKey()) {
            Integer distance = Math.abs(left.getValue() - right.getValue());
            if (distance <= 1)
                return new Pair<>(true, Integer.max(left.getValue(), right.getValue()));
        }
        return new Pair<>(false, 0);
    }

    public boolean isBalanced() {
        return isBalancedUtil(this.root, 1, new Pair<>(false, 0)).getKey();
    }

    private TreeMap<Integer, Pair<Integer, Integer>> maxWidthOfATreeUtil(TreeNode<T> node, Integer x, Integer y, TreeMap<Integer, Pair<Integer, Integer>> treeMap) {
        if (node == null)
            return treeMap;
        TreeMap<Integer, Pair<Integer, Integer>> left = maxWidthOfATreeUtil(node.getLeft(), x - 1, y + 1, treeMap);
        TreeMap<Integer, Pair<Integer, Integer>> right = maxWidthOfATreeUtil(node.getRight(), x + 1, y + 1, left);
        if (right.get(y) == null) {
            if (x < 0) {
                right.put(y, new Pair<>(x, 0));
            } else {
                right.put(y, new Pair<>(0, x));
            }
        } else {
            Pair<Integer, Integer> aux = right.get(y);
            if (x < 0) {
                if (x < aux.getKey()) {
                    right.put(y, new Pair<>(x, aux.getValue()));
                }
            } else {
                if (x > aux.getValue()) {
                    right.put(y, new Pair<>(aux.getKey(), x));
                }
            }
        }
        return right;
    }

    public int getMaxWidth() {
        if (this.root == null)
            return 0;
        TreeMap<Integer, Pair<Integer, Integer>> treeMap = maxWidthOfATreeUtil(this.root, 0, 0, new TreeMap<Integer, Pair<Integer, Integer>>());
        int maxValue = 0;
        if (MapUtils.isNotEmpty(treeMap)) {
            for (Map.Entry<Integer, Pair<Integer, Integer>> entry : treeMap.entrySet()) {
                Pair<Integer, Integer> pair = entry.getValue();
                int distance = pair.getValue() - pair.getKey();
                maxValue = Math.max(maxValue, distance);
            }
        }
        return maxValue;
    }

    private TreeNode<T> convertToDoublyLinkedList(TreeNode<T> node, TreeNode<T> prev) {
        if (node == null)
            return prev;
        TreeNode<T> left = convertToDoublyLinkedList(node.getLeft(), node);
        left.setRight(node);
        TreeNode<T> right = convertToDoublyLinkedList(node.getRight(), node);
        prev.setLeft(right);
        return right;
    }

    public void convertToDoublyLinkedList() {
        TreeNode<T> node = convertToDoublyLinkedList(this.root, this.root);
        while (node.getLeft() != null) {
//            System.out.println(node.getData());
            node = node.getLeft();
        }
        TreeNode<T> temp = node;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getRight();
        }
    }

    public int getMaxWidthUsingLevelOrder() {
        if (this.root == null)
            return 0;
        List<T> output = new LinkedList<>();
        Queue<TreeNode<T>> queue = new LinkedList<>();
        queue.offer(this.root);
        while (CollectionUtils.isNotEmpty(queue)) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode<T> node = queue.poll();
                if (node.getLeft() != null)
                    queue.offer(node.getLeft());
                if (node.getRight() != null)
                    queue.offer(node.getRight());
                output.add(node.getData());
            }
            output.add(null);
        }
        if (CollectionUtils.isNotEmpty(output)) {
            int maxWidth = 0;
            int count = 0;
            for (T item : output) {
                if (item == null) {
                    maxWidth = Math.max(maxWidth, count);
                    count = 0;
                } else {
                    count++;
                }
            }
            return maxWidth;
        }
        return 0;
    }

    public List<T> printZigZag() {
        List<T> list = new LinkedList<>();
        if (this.root != null) {
            Deque<TreeNode<T>> deque = new LinkedList<>();
            deque.offerFirst(this.root);
            int level = 1;
            while (CollectionUtils.isNotEmpty(deque)) {
                int size = deque.size();
                for (int i = 1; i <= size; i++) {
                    if (level % 2 == 0) {
                        TreeNode<T> node = deque.pollLast();
                        if (node.getRight() != null)
                            deque.offerFirst(node.getRight());
                        if (node.getLeft() != null)
                            deque.offerFirst(node.getLeft());
                        list.add(node.getData());
                    } else {
                        TreeNode<T> node = deque.pollFirst();
                        if (node.getLeft() != null)
                            deque.offerLast(node.getLeft());
                        if (node.getRight() != null)
                            deque.offerLast(node.getRight());
                        list.add(node.getData());
                    }
                }
                level++;
            }
        }
        return list;
    }

    private Pair<Map<TreeNode<T>, Integer>, Integer> diameterUtil(TreeNode<T> node, int height, Map<TreeNode<T>, Integer> map) {
        if (node == null)
            return new Pair<Map<TreeNode<T>, Integer>, Integer>(map, 0);
        Pair<Map<TreeNode<T>, Integer>, Integer> left = diameterUtil(node.getLeft(), height + 1, map);
        Pair<Map<TreeNode<T>, Integer>, Integer> right = diameterUtil(node.getRight(), height + 1, left.getKey());
        Integer totalNodes = left.getValue() + right.getValue() + 1;
        Map<TreeNode<T>, Integer> rightMap = right.getKey();
        rightMap.put(node, totalNodes);
        return new Pair<>(rightMap, Math.max(left.getValue(), right.getValue()) + 1);
    }

    public int diameter() {
        Pair<Map<TreeNode<T>, Integer>, Integer> pair = diameterUtil(this.root, 1, new HashMap<TreeNode<T>, Integer>());
        Map<TreeNode<T>, Integer> outputMap = pair.getKey();
        int max = 0;
        if (MapUtils.isNotEmpty(pair.getKey())) {
            for (Map.Entry<TreeNode<T>, Integer> entry : outputMap.entrySet()) {
                max = Math.max(entry.getValue(), max);
            }
        }
        return max;
    }

    static class LcaUtil {
        public boolean found;
        int height;
        boolean n1;
        boolean n2;

        int lca;

        public LcaUtil(boolean found, int height, boolean n1, boolean n2, int lca) {
            this.found = found;
            this.height = height;
            this.n1 = n1;
            this.n2 = n2;
            this.lca = lca;
        }
    }

    private LcaUtil lcaUtil(TreeNode<Integer> node, int height, Integer n1, Integer n2, LcaUtil lcaUtil) {
        if (node == null)
            return lcaUtil;
        LcaUtil left = lcaUtil(node.getLeft(), height + 1, n1, n2, lcaUtil);
        LcaUtil right = lcaUtil(node.getRight(), height + 1, n1, n2, left);
        if ((!left.found && (left.n1 || left.n2)) && (!right.found && (right.n1 || right.n2)))
            return new LcaUtil(true, height, true, true, node.getData());
        else if ((!left.found && (left.n1 && n2 == node.getData())) || (!left.found && (left.n2 && n1 == node.getData())) || (!right.found && (right.n1 && n2 == node.getData())) || (!right.found && (right.n2 && n1 == node.getData())))
            return new LcaUtil(true, height, true, true, node.getData());
        else if (n1 == node.getData())
            return new LcaUtil(false, height, true, false, Integer.MIN_VALUE);
        else if (n2 == node.getData())
            return new LcaUtil(false, height, false, true, Integer.MIN_VALUE);
        return new LcaUtil(false, height, false, false, Integer.MIN_VALUE);
    }


    public int lca(TreeNode<Integer> node, int n1, int n2) {
//        Pair<Integer, List<Integer>> pair = lcaUtil(node, n1, n2, new Pair<Integer, List<Integer>>(0, new ArrayList<Integer>()));
//        if (pair.getValue().size() == 2)
//            return pair.getKey();
//        else
//            return 0;
        LcaUtil lcaUtil = lcaUtil(node, 0, n1, n2, new LcaUtil(false, 0, false, false, Integer.MIN_VALUE));
        return (lcaUtil.lca == Integer.MIN_VALUE) ? 0 : lcaUtil.lca;
    }

    public static void main(String args[]) {
        BinaryTree<Integer> tree = new BinaryTree<>();
        tree.add(40);
        tree.add(10);
        tree.add(20);
        tree.add(70);
        tree.add(80);
        tree.add(60);
        tree.add(5);
//        tree.add(10);
        tree.add(15);
        tree.add(9);
        List<Integer> levelOrder = tree.levelOrderTraversal();
        System.out.println(levelOrder);
        List<Integer> preOrder = tree.preOrder();
        System.out.println(preOrder);
        List<Integer> inOrder = tree.inOrder();
        System.out.println(inOrder);
        List<Integer> postOrder = tree.postOrder();
        System.out.println(postOrder);
        tree.printLineByLine();
        int size = tree.size();
        System.out.printf("\nThe size of the tree is : %d", size);
        Integer maxValue = tree.getMax(tree.getRoot());
        System.out.printf("\nThe maximum value of the tree is %d", maxValue);
        int height = tree.height();
        System.out.printf("\nThe height of the tree is: %d", height);
        List<Integer> elementsAtDistanceK = tree.itemsAtDistanceK(2);
        System.out.printf("\nElements at distance %d are : " + elementsAtDistanceK, 2);
        List<Integer> elementsAtDistanceK_depth = tree.getItemsAtDistanceK(2);
        System.out.printf("\nElements at distance %d are : " + elementsAtDistanceK_depth, 2);
        List<Integer> leftViewOftheBinaryTree = tree.printLeftView();
        System.out.printf("\nPrint left view of the binary tree: " + leftViewOftheBinaryTree);
        BinaryTree<Integer> tree1 = new BinaryTree<>();
        tree1.add(1);
        tree1.add(3);
        tree1.add(10);
        tree1.add(5);
        tree1.add(7);
        tree1.add(9);
        tree1.add(5);
        tree1.add(5);
        tree1.add(9);
        tree1.add(2);
        tree1.add(10);
        System.out.printf("\nChildren sum property: " + tree1.childrenSumProperty(tree1.getRoot()));
        int maxWidth = tree1.getMaxWidth();
        System.out.printf("\nMaximum width of a binary tree: " + maxWidth);
        BinaryTree<Integer> tree2 = new BinaryTree<>();
        tree2.add(20);
        tree2.add(10);
        tree2.add(30);
//        tree2.convertToDoublyLinkedList();
        List<Integer> spiralList = tree.printZigZag();
        System.out.printf("\nSpiral view : " + spiralList);
        int diameter = tree2.diameter();
        System.out.print("\nThe diameter of the tree is : " + diameter);
        int n1 = 60;
        int n2 = 80;
        int lca = tree.lca(tree.root, n1, n2);
        System.out.printf("\nThe LCA of n1= %d, n2= %d is %d", n1, n2, lca);
    }

}
