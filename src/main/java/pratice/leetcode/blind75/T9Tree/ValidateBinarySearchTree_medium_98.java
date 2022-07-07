package pratice.leetcode.blind75.T9Tree;

import pratice.common.Out;
import pratice.leetcode.blind75.T9Tree.common.TreeNode;

public class ValidateBinarySearchTree_medium_98 {
    static class Solution {
        public boolean isValidBST(TreeNode root) {
            return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        private boolean validate(TreeNode root, long min, long max) {
            if (root == null) return true;
            if (root.val <= min || root.val >= max) return false;

            return validate(root.left, min, root.val) && validate(root.right, root.val, max);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree("5,1,4,null,null,3,6");
        Out.print(sol.isValidBST(root));
    }
}
