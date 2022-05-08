package com.gfg.companywise.amazon;

import com.common.Out;

public class MaximumDifferenceBetweenNodeAndItsAncestor {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static public class Solution {
        int maxDiff(Node root) {
            int res[] = {Integer.MIN_VALUE};
            calcMaxDiff(root, res);
            return res[0];
        }

        private int calcMaxDiff(Node root, int[] res) {
            if (root == null) return Integer.MAX_VALUE;
            if (root.left == null && root.right == null) return root.data;

            int val = Math.min(calcMaxDiff(root.left, res), calcMaxDiff(root.right, res));
            res[0] = Math.max(res[0], root.data - val);

            return Math.min(val, root.data);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node root = new Node(8);
        root.left = new Node(3);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);

        root.right = new Node(10);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        Out.print(sol.maxDiff(root));
    }
}
