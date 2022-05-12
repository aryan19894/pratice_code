package pratice.striver.DSAExperience.T12Tree.BinaryTree;

import pratice.common.Out;
import pratice.striver.DSAExperience.T12Tree.common.TreeNode;

public class LowestCommonAncestor_medium_236 {
    static class Solution {
        // [Optimal] TC: O(n), O(n) - we traverse left subtree and right subtree and compare both node P & Q.
        // if not in both the subtrees then root will be the  LCA.
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            //base case
            if (root == null || root.equals(p) || root.equals(q))
                return root;

            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);

            //result
            if (left == null) return right;
            else if (right == null) return left;
            else return root; //both left and right are not null, we found our result
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        Out.print(sol.lowestCommonAncestor(root, p, q));
    }
}
