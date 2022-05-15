package pratice.leetcode.blind75.T9Tree;

import pratice.leetcode.blind75.T9Tree.common.TreeNode;

public class InvertBinaryTree_easy_226 {
    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root == null) return null;
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);
            invertTree(root.right);
            return root;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree("4,2,7,1,3,6,9");
        TreeNode.print(sol.invertTree(root));
    }
}
