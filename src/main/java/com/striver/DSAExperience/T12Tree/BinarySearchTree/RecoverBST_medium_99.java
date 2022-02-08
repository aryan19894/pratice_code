package com.striver.DSAExperience.T12Tree.BinarySearchTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

public class RecoverBST_medium_99 {
    static class Solution {
        TreeNode first = null;
        TreeNode prev = null;
        TreeNode last = null;

        public void recoverTree(TreeNode root) {
            first = last = null;
            prev = new TreeNode(Integer.MIN_VALUE);
            inorder(root);

            int t = first.val;
            first.val = last.val;
            last.val = t;
        }

        private void inorder(TreeNode node) {
            if (node == null) return;

            inorder(node.left);
            if (prev != null && node.val < prev.val) {
                if (first == null)
                    first = prev;
                last = node;
            }
            prev = node;
            inorder(node.right);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{3,1,4,null,null,2});
        Out.print(root);
        sol.recoverTree(root);
        Out.print(root);
    }
}
