package pratice.leetcode.blind75.T9Tree;

import pratice.leetcode.blind75.T9Tree.common.TreeNode;

public class LowestCommonAncestorOfABinarySearchTree_easy_235 {
    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;

            if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(root.left, p, q);
            else if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(root.right, p, q);
            return root;
        }

        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode curr = root;
            while (curr != null) {
                if (p.val < curr.val && q.val < curr.val) curr = curr.left;
                else if (p.val > curr.val && q.val > curr.val) curr = curr.right;
                else return curr;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree("6,2,8,0,4,7,9,null,null,3,5");
        TreeNode p = TreeNode.toTree("2");
        TreeNode q = TreeNode.toTree("8");

        //TreeNode.print(sol.lowestCommonAncestor(root, p, q));
        TreeNode ans = sol.lowestCommonAncestor2(root, p, q);
        System.out.println(ans.val);

    }
}
