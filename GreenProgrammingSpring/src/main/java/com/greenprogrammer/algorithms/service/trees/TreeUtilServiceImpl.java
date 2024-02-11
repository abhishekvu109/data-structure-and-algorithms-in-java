package com.greenprogrammer.algorithms.service.trees;

import com.greenprogrammer.algorithms.constants.TreeTraversalStrategy;
import com.greenprogrammer.algorithms.dto.nodes.TreeNode;
import com.greenprogrammer.algorithms.intf.ListInf;
import com.greenprogrammer.algorithms.intf.Tree;
import com.greenprogrammer.algorithms.list.linkedList.CircularLinkedList;
import com.greenprogrammer.algorithms.list.linkedList.DoublyLinkedList;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TreeUtilServiceImpl implements TreeUtilService {

    private final TreeUtilServiceImplHelper treeUtilServiceImplHelper;

    @Override
    public <T> List<T> printNodesAtK(Tree<T> tree, int k) {
        return treeUtilServiceImplHelper.printNodesAtK(tree.getRoot(), new LinkedList<T>(), k);
    }


    @Override
    public <T> List<T> levelOrderLineByLine(Tree<T> tree) {
        return treeUtilServiceImplHelper.levelOrderLineByLine(tree.getRoot());
    }


    @Override
    public <T> List<T> printLeftViewOfBinaryTree(Tree<T> tree, TreeTraversalStrategy strategy) {
        return treeUtilServiceImplHelper.printLeftViewOfBinaryTree(tree.getRoot(), strategy);
    }

    @Override
    public <T> List<T> printRightViewOfBinaryTree(Tree<T> tree, TreeTraversalStrategy strategy) {
        return treeUtilServiceImplHelper.printRightViewOfBinaryTree(tree.getRoot(), strategy);
    }

    @Override
    public <E extends Number> boolean isChildrenSumProperty(Tree<E> tree, TreeTraversalStrategy strategy) {
        return treeUtilServiceImplHelper.isChildrenSumProperty(tree.getRoot(), strategy);
    }

    @Override
    public <T> boolean isTreeBalanced(Tree<T> tree, TreeTraversalStrategy strategy) {
        int distance = 1;
        if (strategy == TreeTraversalStrategy.POST_ORDER) {
            Map<TreeNode<T>, Integer> map = treeUtilServiceImplHelper.isTreeBalanced(tree.getRoot(), new HashMap<TreeNode<T>, Integer>());
            for (Map.Entry<TreeNode<T>, Integer> entry : map.entrySet()) {
                if (entry.getKey().getLeft() != null) {
                    int left = map.get(entry.getKey().getLeft());
                    int right = map.get(entry.getKey().getRight());
                    if (Math.abs(left - right) > distance)
                        return false;
                }
            }
            return true;
        }
        return true;
    }

    @Override
    public <T> Tree<T> mirrorTree(Tree<T> tree) {
        tree.setRoot(treeUtilServiceImplHelper.mirrorTree(tree.getRoot()));
        return tree;
    }

    @Override
    public <T> boolean isMirrorTree(Tree<T> tree, TreeTraversalStrategy strategy) {
        return false;
    }

    @Override
    public <E extends Comparable<E>> E maximum(Tree<E> tree, TreeTraversalStrategy strategy) {
        return treeUtilServiceImplHelper.maximum(tree.getRoot(), strategy);
    }

    @Override
    public <T> boolean isFoldableBinaryTree(Tree<T> tree) {
        return false;
    }

    @Override
    public <T> int verticalWidthOfABinaryTree(Tree<T> tree, TreeTraversalStrategy strategy) {
        return treeUtilServiceImplHelper.verticalWidthOfABinaryTree(tree.getRoot(), strategy);
    }

    @Override
    public <T> int maximumWidthOfABinaryTree(Tree<T> tree, TreeTraversalStrategy strategy) {
        return treeUtilServiceImplHelper.maximumWidthOfABinaryTree(tree.getRoot(), strategy);
    }

    @Override
    public <T> DoublyLinkedList<T> convertBinaryTreeToBinaryTree(Tree<T> tree) {
        return null;
    }

    @Override
    public <T> void constructBinaryTreeFromInOrderAndPreOrder(Tree<T> tree) {

    }

    @Override
    public <T> void treeTraversalInSpiralForm(Tree<T> tree, TreeTraversalStrategy strategy) {
        treeUtilServiceImplHelper.treeTraversalInSpiralForm(tree.getRoot(), strategy);
    }

    @Override
    public <E extends Number> void lcaOfBinaryTree(Tree<E> tree) {

    }

    @Override
    public <T> void burnABinaryTreeFromLeaf(Tree<T> tree) {

    }

    @Override
    public <T> int countNodesInCompleteBinaryTree(Tree<T> tree) {
        return 0;
    }

    @Override
    public <T> void serializeBinaryTree(Tree<T> tree) {

    }

    @Override
    public <T> ListInf<T> iterativeInOrder(Tree<T> tree) {
        return null;
    }

    @Override
    public <T> ListInf<T> iterativePreOrder(Tree<T> tree) {
        TreeNode<T> node = tree.getRoot();
        Stack<TreeNode<T>> stack = new Stack<>();
        ListInf<T> output = new DoublyLinkedList<>();
        if (node != null)
            stack.push(node);
        while (!stack.isEmpty()) {
            TreeNode<T> current = stack.pop();
            if (current.getRight() != null)
                stack.push(current.getLeft());
            if (current.getLeft() != null)
                stack.push(current.getLeft());
        }
        return output;
    }

    @Override
    public <T> ListInf<T> iterativePostOrder(Tree<T> tree) {
        return null;
    }

    @Override
    public <T> DoublyLinkedList<T> convertToDoublyLinkedList(Tree<T> tree) {
        return null;
    }

    @Override
    public <T> CircularLinkedList<T> convertToCircularLinkedList(Tree<T> tree) {
        return null;
    }
}
