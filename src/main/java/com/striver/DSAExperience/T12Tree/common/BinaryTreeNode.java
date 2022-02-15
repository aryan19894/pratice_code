package com.striver.DSAExperience.T12Tree.common;

import com.common.converter.Str;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode<T> left;
    public BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }

    public static BinaryTreeNode toTree(String input) {
        return toTree(Str.toArray(input));
    }

    public static BinaryTreeNode toTree(String[] input) {
        return toTree(input);
    }

    public static BinaryTreeNode toTree(Integer[] ip) {
        if (ip.length == 0 || ip[0] == -1)
            return null;

        BinaryTreeNode<Integer> root = new BinaryTreeNode(ip[0]);
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.add(root);

        for (int i = 1; i < ip.length && !q.isEmpty(); i++) {
            BinaryTreeNode currNode = q.poll();
            if (ip[i] != null) {
                currNode.left = new BinaryTreeNode(ip[i]);
                q.add(currNode.left);
            }
            if (ip[++i] != null) {
                currNode.right = new BinaryTreeNode(ip[i]);
                q.add(currNode.right);
            }
        }
        return root;
    }

    public static void print(BinaryTreeNode root) {
        Queue<BinaryTreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            for (int i = 0; i < levelNum; i++) {
                BinaryTreeNode ref = q.poll();
                if (ref != null) {
                    q.offer(ref.left);
                    q.offer(ref.right);
                    System.out.print(ref.data + " ");
                } else
                    System.out.print("null ");
            }
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "BinaryTreeNode{" +
                "data=" + data +
                '}';
    }
}
