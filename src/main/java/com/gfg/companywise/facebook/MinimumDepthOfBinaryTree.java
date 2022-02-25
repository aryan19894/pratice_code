package com.gfg.companywise.facebook;

import com.common.Out;

public class MinimumDepthOfBinaryTree {
    static class Node {
        public int data;
        public Node left, right;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static public class Solution {
        int minDepth(Node root) {
            if (root == null) return 0;
            else if (root.left == null)
                return 1 + minDepth(root.right);
            else if (root.right == null)
                return 1 + minDepth(root.left);
            else
                return 1 + Math.min(minDepth(root.left), minDepth(root.right));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node root = null;
        Out.print(sol.minDepth(root));
    }
}
