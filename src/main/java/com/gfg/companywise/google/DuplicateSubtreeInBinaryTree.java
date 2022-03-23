package com.gfg.companywise.google;

import com.common.Out;

import java.util.HashSet;

public class DuplicateSubtreeInBinaryTree {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static char MARKER = '$';

    static public class Solution {
        int dupSub(Node root) {
            HashSet<String> subtree = new HashSet<>();
            String ans = dupSubUtil(root, subtree);
            return ans.isEmpty() ? 1 : 0;
        }

        private String dupSubUtil(Node root, HashSet<String> subtree) {
            String s = "";
            if (root == null) return s + MARKER;

            String left = dupSubUtil(root.left, subtree);
            if (left.equals(s)) return s;

            String right = dupSubUtil(root.right, subtree);
            if (right.equals(s)) return s;

            //serialize
            s += (char)root.data + left + right;

            if (s.length() > 3 && subtree.contains(s)) return "";

            subtree.add(s);
            return s;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node root = new Node('A');
        root.left = new Node('B');
        root.right = new Node('C');
        root.left.left = new Node('D');
        root.left.right = new Node('E');
        root.right.right = new Node('B');
//        root.right.right.right = new Node('E');
//        root.right.right.left = new Node('D');

        Out.print(sol.dupSub(root) == 1 ? "yes" : "no");
    }
}
