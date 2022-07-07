package pratice.leetcode.blind75.T9Tree;

import pratice.common.Out;
import pratice.leetcode.blind75.T9Tree.common.TreeNode;

public class BinaryTreeMaximumPathSum_hard_124 {
    static class Solution {
        public int maxPathSum(TreeNode root) {
            int[] result = {Integer.MIN_VALUE};
            calcHeight(root, result);
            return result[0];
        }

        private int calcHeight(TreeNode root, int[] result) {
            if (root == null) return 0;

            int left = Math.max(0, calcHeight(root.left, result));
            int right = Math.max(0, calcHeight(root.right, result));
            result[0] = Math.max(result[0], left + right + root.val);

            return root.val + Math.max(left, right);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree("2,-1");
        Out.print(sol.maxPathSum(root));
    }
}
