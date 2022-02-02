package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.TreeNode;

public class DiameterOfBinaryTree_easy_543 {
    static class Solution {
        // [Optimal] TC: O(n) - use post-order traversal and keep calculating the height of the left and right subtrees.
        // Once we have the heights at the current node, we can easily calculate both the diameter and height of the
        // current node.
        // SC: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree )
        public int diameterOfBinaryTree(TreeNode root) {
            int[] res = new int[1];
            height(root, res);
            return res[0];
        }

        private int height(TreeNode node, int[] res) {
            if (node == null) return 0;

            int left = height(node.left, res);
            int right = height(node.right, res);
            res[0] = Math.max(res[0], left + right);
            return 1 + Math.max(left, right);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        Out.print(sol.diameterOfBinaryTree(root));
    }
}
