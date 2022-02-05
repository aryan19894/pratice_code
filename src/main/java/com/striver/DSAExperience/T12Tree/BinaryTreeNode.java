package com.striver.DSAExperience.T12Tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public static BinaryTreeNode toTree(Integer[] ip) {
        if (ip.length == 0 || ip[0] == -1)
            return null;

        // Create the root of the tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode(ip[0]);
        // Push the root to the queue
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            BinaryTreeNode currNode = queue.poll();
            Integer currVal = ip[i++];

            // If the left child is not null
            if (currVal != null) {
                currNode.left = new BinaryTreeNode(currVal);
                queue.add(currNode.left);
            }

            // For the right child
            if (i >= ip.length) break;

            currVal = ip[i++];
            if (currVal != null) {
                currNode.right = new BinaryTreeNode(currVal);
                queue.add(currNode.right);
            }
        }
        return root;
    }
}
