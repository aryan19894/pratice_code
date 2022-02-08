package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

public class SymmetricTree_easy_101 {
    static class Solution {
		//TC: O(N)
		//SC: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree)
        public boolean isSymmetric(TreeNode root) {
            return root == null || isSimilar(root.left, root.right);
        }

        private boolean isSimilar(TreeNode left, TreeNode right) {
            if (left == null || right == null)
                return left == right;
            return left.val == right.val &&
                    isSimilar(left.left, right.right) &&
                    isSimilar(left.right, right.left);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{1, 2, 2, null, 3, null, 3});
        Out.print(sol.isSymmetric(root));
    }
}
