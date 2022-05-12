package pratice.striver.DSAExperience.T12Tree.BinaryTree;

import pratice.common.Out;
import pratice.striver.DSAExperience.T12Tree.common.TreeNode;

public class CountCompleteTreeNodes_medium_222 {
    static class Solution {
        // [Optimal] TC: O(logN2) - logN square for find height for left and traverse node for finding height would be logN
        // SC: O(logN). recursive stack for finding the height
        public int countNodes(TreeNode root) {
            if (root == null) return 0;

            int left = heightLeft(root);
            int right = heightRight(root);

            if (left == right) return (2 << left) - 1;
            else return countNodes(root.left) + countNodes(root.right) + 1;
        }

        private int heightRight(TreeNode root) {
            int count = 0;
            while (root.right != null) {
                count++;
                root = root.right;
            }
            return count;
        }

        private int heightLeft(TreeNode root) {
            int count = 0;
            while (root.left != null) {
                count++;
                root = root.left;
            }
            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{1, 2, 3, 4, 5, 6});
        Out.print(sol.countNodes(root));
    }
}
