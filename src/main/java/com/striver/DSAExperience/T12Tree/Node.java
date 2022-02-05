package com.striver.DSAExperience.T12Tree;

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

    public static Node toTree(String str) {
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        return toTree(ip);
    }

    public static Node toTree(String[] ip) {
        if (ip.length == 0 || ip[0] == "N")
            return null;

        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {
            Node currNode = queue.poll();
            String currVal = ip[i++];

            // If the left child is not null
            if (!currVal.equals("N")) {
                currNode.left = new Node(Integer.parseInt(currVal));
                queue.add(currNode.left);
            }

            // For the right child
            if (i >= ip.length) break;

            currVal = ip[i++];
            if (!currVal.equals("N")) {
                currNode.right = new Node(Integer.parseInt(currVal));
                queue.add(currNode.right);
            }
        }
        return root;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", hd=" + hd +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
