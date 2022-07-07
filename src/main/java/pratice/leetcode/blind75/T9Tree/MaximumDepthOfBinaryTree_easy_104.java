package pratice.leetcode.blind75.T9Tree;

import pratice.common.Out;
import pratice.leetcode.blind75.T9Tree.common.TreeNode;

public class MaximumDepthOfBinaryTree_easy_104 {
    static class Solution {
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree("1,null,2");
        Out.print(sol.maxDepth(root));
    }
}
