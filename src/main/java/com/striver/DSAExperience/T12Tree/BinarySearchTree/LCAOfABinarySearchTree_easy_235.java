package com.striver.DSAExperience.T12Tree.BinarySearchTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.TreeNode;

public class LCAOfABinarySearchTree_easy_235 {
    static class Solution {
        // [Optimal Iterative] TC: O(H), O(1): height of BST. we return the node.
        // when the path is split through greater or smaller check
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            TreeNode curr = root;
            while (curr != null) {
                if (p.val < curr.val && q.val < curr.val)
                    curr = curr.left;
                else if (p.val > curr.val && q.val > curr.val)
                    curr = curr.right;
                else return curr;
            }
            return null;
        }

        // [Optimal Recursive] TC: O(H), O(1): height of BST. we return the node.
        // when the path is split through greater or smaller check
        public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null) return null;
            if (p.val < root.val && q.val < root.val)
                return lowestCommonAncestor2(root.left, p, q);
            else if (p.val > root.val && q.val > root.val)
                return lowestCommonAncestor2(root.right, p, q);

            return root;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{6, 2, 8, 0, 4, 7, 9, null, null, 3, 5});
        TreeNode p = new TreeNode(3);
        TreeNode q = new TreeNode(11);
        Out.print(sol.lowestCommonAncestor(root, p, q));
    }
}
