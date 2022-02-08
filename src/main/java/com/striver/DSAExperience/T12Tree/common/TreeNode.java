package com.striver.DSAExperience.T12Tree.common;

import com.common.Array;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TreeNode extends GlobalNode{
    public int val;
    public TreeNode left, right;

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode() {

    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
    }

    public int getVal() {
        return val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public static TreeNode newInstance() {
        return new TreeNode();
    }

    public static TreeNode toTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String[] ip = str.split(" ");
        return toTree(Array.toInteger(ip));
    }

    public static TreeNode toTree(Integer[] ip) {
        if (ip.length == 0 || ip[0] == -1)
            return null;

        // Create the root of the tree
        TreeNode root = new TreeNode(ip[0]);
        // Push the root to the queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            TreeNode currNode = queue.poll();
            Integer currVal = ip[i++];

            // If the left child is not null
            if (currVal != null) {
                currNode.left = new TreeNode(currVal);
                queue.add(currNode.left);
            }

            // For the right child
            if (i >= ip.length) break;

            currVal = ip[i++];
            if (currVal != null) {
                currNode.right = new TreeNode(currVal);
                queue.add(currNode.right);
            }
        }
        return root;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return val == treeNode.val;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val);
    }

}
