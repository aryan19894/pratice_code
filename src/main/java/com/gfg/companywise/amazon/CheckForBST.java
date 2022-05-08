package com.gfg.companywise.amazon;

import com.common.Out;

public class CheckForBST {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static public class Solution {
        boolean isBST(Node root) {
            return checkBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        private boolean checkBST(Node node, int min, int max) {
            if (node == null) return true;
            if (node.data <= min || node.data >= max) return false;

            return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node root = null;
        Out.print(sol.isBST(root));
    }
}
