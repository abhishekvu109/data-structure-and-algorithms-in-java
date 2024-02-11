package com.greenprogrammer.algorithms.intf;

import com.greenprogrammer.algorithms.constants.TreeStrategy;
import com.greenprogrammer.algorithms.constants.TreeTraversalStrategy;
import com.greenprogrammer.algorithms.dto.nodes.TreeNode;

public interface Tree<T> extends DataStructure<T> {
    public T add(T data, TreeStrategy strategy);

    public ListInf<T> traverse(TreeTraversalStrategy strategy);

    public int height(TreeTraversalStrategy strategy);

    public int size();


    public int diameter();

    public TreeNode<T> getRoot();

    public void setRoot(TreeNode<T> root);


}
