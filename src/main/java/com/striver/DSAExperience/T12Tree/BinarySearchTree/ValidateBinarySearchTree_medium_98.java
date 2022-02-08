package com.striver.DSAExperience.T12Tree.BinarySearchTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

public class ValidateBinarySearchTree_medium_98 {
    static class Solution {
        // [Optimal] TC: O(N), O(1): we verify through the range of its parent root and parent of parent root
        public boolean isValidBST(TreeNode root) {
            return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean isValidBST(TreeNode root, long min, long max) {
            if (root == null) return true;
            if (root.val <= min || root.val >= max)
                return false;

            return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{5, 1, 4, null, null, 3, 6});
        Out.print(sol.isValidBST(root));
    }
}
