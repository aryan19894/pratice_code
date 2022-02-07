package com.striver.DSAExperience.T12Tree.BinarySearchTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.TreeNode;

public class CeilInBST_Easy {
    static class Solution {

        // [Optimal] TC: O(logN), O(1) - use rule of BST
        public int ceil(TreeNode root, int key) {
            int ceil = -1;
            while (root != null) {
                if (root.val == key) return root.val;

                if (key > root.val)
                    root = root.right;
                else {
                    ceil = root.val;
                    root = root.left;
                }
            }
            return ceil;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{8, 5, 12, 4, 7, 10, 14, null, null, 6, null, null, null, 13});
        int val = 7;
        Out.print(sol.ceil(root, val));
    }
}
