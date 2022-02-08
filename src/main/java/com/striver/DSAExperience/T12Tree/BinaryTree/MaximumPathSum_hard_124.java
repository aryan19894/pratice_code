package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

public class MaximumPathSum_hard_124 {
    static class Solution {
        // [Optimal] TC: O(n) - use post-order traversal and keep calculating the height of the left and right subtrees.
        // Once we have the heights at the current node, we can easily calculate the maximum value with current node value
        // SC: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree )
        public int maxPathSum(TreeNode root) {
            int[] res = new int[1];
            res[0] = Integer.MIN_VALUE;
            height(root, res);
            return res[0];
        }

        private int height(TreeNode root, int[] res) {
            if (root == null) return 0;

            int left = Math.max(0, height(root.left, res));
            int right = Math.max(0, height(root.right, res));

            res[0] = Math.max(res[0], left + right + root.val);

            return root.val + Math.max(left, right);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(-1);

        Out.print(sol.maxPathSum(root));
    }
}
