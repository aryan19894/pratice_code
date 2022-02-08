package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.striver.DSAExperience.T12Tree.common.TreeNode;

public class BalancedBinaryTree_easy_110 {
    static class Solution {
        // [Better] TC: O(n*n) - For every node, Height Function is called which takes O(N) Time.
        // SC: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree )
        public boolean isBalanced(TreeNode root) {
            if (root == null) return true;
            int left = findHeight(root.left);
            int right = findHeight(root.right);

            if (Math.abs(left - right) > 1) return false;

            if (!isBalanced(root.left) || !isBalanced(root.right))
                return false;
            return true;
        }

        private int findHeight(TreeNode node) {
            if (node == null) return 0;
            return 1 + Math.max(findHeight(node.left), findHeight(node.right));
        }

        // [Optimal] TC: O(n) - use post-order traversal and keep calculating the height of the left and right subtrees.
        // Once we have the heights at the current node, we can easily calculate difference of both heights.
        // SC: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree )
        public boolean isBalanced2(TreeNode root) {
            return dfsHeight(root) != -1;
        }

        public int dfsHeight(TreeNode node) {
            if (node == null) return 0;

            int lh = dfsHeight(node.left);
            if (lh == -1) return -1;
            int rh = dfsHeight(node.right);
            if (rh == -1) return -1;

            if (Math.abs(lh - rh) > 1) return -1;

            return Math.max(lh, rh) + 1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sol.isBalanced(root));
        System.out.println(sol.isBalanced2(root));
    }
}
