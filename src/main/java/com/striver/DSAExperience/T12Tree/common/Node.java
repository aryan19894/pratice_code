package com.striver.DSAExperience.T12Tree.common;

import com.common.converter.Str;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    public int data;
    public int hd;
    public Node left, right;

    public Node() {
    }

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, int hd) {
        this.data = data;
        this.hd = hd;
    }

    public Node(int data, Node left, Node right) {
        this.data = data;
        this.left = left;
        this.right = right;
        this.hd = Integer.MAX_VALUE;
    }

    public static Node toTree(Integer[] ip) {
        if (ip.length == 0 || ip[0] == -1)
            return null;

        Node root = new Node(ip[0]);
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        for (int i = 1; i < ip.length && !q.isEmpty(); i++) {
            Node currNode = q.poll();
            if (ip[i] != null) {
                currNode.left = new Node(ip[i]);
                q.add(currNode.left);
            }
            if (ip[++i] != null) {
                currNode.right = new Node(ip[i]);
                q.add(currNode.right);
            }
        }
        return root;
    }

    public static Node toTree(String input) {
        return toTree(Str.toArray(input));
    }

    public static Node toTree(String[] input) {
        return toTree(input);
    }

    public static void print(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            for (int i = 0; i < levelNum; i++) {
                Node ref = q.poll();
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
        return "Node{" +
                "data=" + data +
                '}';
    }
}
