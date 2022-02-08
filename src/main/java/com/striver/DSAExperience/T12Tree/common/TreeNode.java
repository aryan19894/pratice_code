package com.striver.DSAExperience.T12Tree.common;

import com.common.Str;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class TreeNode<T> {
    public int val, data;
    public TreeNode<T> left, right;

    public TreeNode(int val) {
        this.val = this.data = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode toTree(Integer[] ip) {
        if (ip.length == 0 || ip[0] == -1)
            return null;

        TreeNode<Integer> root = new TreeNode(ip[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for (int i = 1; i < ip.length && !q.isEmpty(); i++) {
            TreeNode currNode = q.poll();
            if (ip[i] != null) {
                currNode.left = new TreeNode(ip[i]);
                q.add(currNode.left);
            }
            if (ip[++i] != null) {
                currNode.right = new TreeNode(ip[i]);
                q.add(currNode.right);
            }
        }
        return root;
    }

    public static TreeNode toTree(String input) {
        return toTree(Str.toArray(input));
    }

    public static TreeNode toTree(String[] input) {
        return toTree(input);
    }

    public static void print(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode ref = q.poll();
                if (ref != null) {
                    q.offer(ref.left);
                    q.offer(ref.right);
                    System.out.print(ref.val + " ");
                } else
                    System.out.print("null ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                '}';
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
