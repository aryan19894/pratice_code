package com.striver.DSAExperience.T12Tree.BinarySearchTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

public class InsertIntoABinarySearchTree_medium_701 {
    static class Solution {
        // [Optimal] TC: O(logN), O(1) - use rule of BST
        public TreeNode insertIntoBST(TreeNode root, int key) {
            if (root == null)
                return new TreeNode(key);

            TreeNode curr = root;
            while (true) {
                if (key <= curr.val) {
                    if (curr.right != null) curr = curr.right;
                    else {
                        curr.right = new TreeNode(key);
                        break;
                    }
                } else {
                    if (curr.left != null) curr = curr.left;
                    else {
                        curr.left = new TreeNode(key);
                        break;
                    }
                }
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{4, 2, 7, 1, 3, 4});
        int val = 5;
        Out.printTree(sol.insertIntoBST(root, val));
    }
}
