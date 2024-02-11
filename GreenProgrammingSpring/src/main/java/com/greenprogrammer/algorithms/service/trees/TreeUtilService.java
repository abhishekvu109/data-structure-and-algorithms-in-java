package com.greenprogrammer.algorithms.service.trees;

import com.greenprogrammer.algorithms.constants.TreeTraversalStrategy;
import com.greenprogrammer.algorithms.intf.ListInf;
import com.greenprogrammer.algorithms.intf.Tree;
import com.greenprogrammer.algorithms.list.linkedList.CircularLinkedList;
import com.greenprogrammer.algorithms.list.linkedList.DoublyLinkedList;

import java.util.List;

public interface TreeUtilService {
    public <T> List<T> printNodesAtK(Tree<T> tree, int k);

    public <T> List<T> levelOrderLineByLine(Tree<T> tree);

    public <T> List<T> printLeftViewOfBinaryTree(Tree<T> tree, TreeTraversalStrategy strategy);

    public <T> List<T> printRightViewOfBinaryTree(Tree<T> tree, TreeTraversalStrategy strategy);

    public <E extends Number> boolean isChildrenSumProperty(Tree<E> tree, TreeTraversalStrategy strategy);

    public <T> boolean isTreeBalanced(Tree<T> tree, TreeTraversalStrategy strategy);

    public <T> boolean isMirrorTree(Tree<T> tree, TreeTraversalStrategy strategy);

    public <T> Tree<T> mirrorTree(Tree<T> tree);

    public <T> boolean isFoldableBinaryTree(Tree<T> tree);

    public <T> int verticalWidthOfABinaryTree(Tree<T> tree, TreeTraversalStrategy strategy);

    public <T> int maximumWidthOfABinaryTree(Tree<T> tree, TreeTraversalStrategy strategy);

    public <T> DoublyLinkedList<T> convertBinaryTreeToBinaryTree(Tree<T> tree);

    public <T> void constructBinaryTreeFromInOrderAndPreOrder(Tree<T> tree);

    public <T> void treeTraversalInSpiralForm(Tree<T> tree, TreeTraversalStrategy strategy);

    public <E extends Number> void lcaOfBinaryTree(Tree<E> tree);

    public <T> void burnABinaryTreeFromLeaf(Tree<T> tree);

    public <T> int countNodesInCompleteBinaryTree(Tree<T> tree);

    public <T> void serializeBinaryTree(Tree<T> tree);

    public <T> ListInf<T> iterativeInOrder(Tree<T> tree);

    public <T> ListInf<T> iterativePreOrder(Tree<T> tree);

    public <T> ListInf<T> iterativePostOrder(Tree<T> tree);

    public <T> DoublyLinkedList<T> convertToDoublyLinkedList(Tree<T> tree);

    public <T> CircularLinkedList<T> convertToCircularLinkedList(Tree<T> tree);

    public <E extends Comparable<E>> E maximum(Tree<E> tree, TreeTraversalStrategy strategy);
}
