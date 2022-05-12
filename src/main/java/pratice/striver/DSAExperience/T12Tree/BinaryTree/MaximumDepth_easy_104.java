package pratice.striver.DSAExperience.T12Tree.BinaryTree;

import pratice.striver.DSAExperience.T12Tree.common.TreeNode;

public class MaximumDepth_easy_104 {
    static class Solution {
        // [Optimal] TC: O(n) - we use left & right children’s maximum depth
        // SC: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree )
        public int maxDepth(TreeNode root) {
            if (root == null) return 0;
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sol.maxDepth(root));
    }
}
