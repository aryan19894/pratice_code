package com.striver.DSAExperience.T12Tree.BinarySearchTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.TreeNode;

public class FloorInBST_Easy {
    static class Solution {

        // [Optimal] TC: O(logN), O(1) - use rule of BST
        public int floor(TreeNode root, int key) {
            int floor = -1;
            while (root != null) {
                if (root.val == key) return root.val;

                if (key > root.val) {
                    floor = root.val;
                    root = root.right;
                } else
                    root = root.left;
            }
            return floor;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{8, 5, 12, 4, 7, 10, 14, null, null, 6, null, null, null, 13});
        int val = 17;
        Out.print(sol.floor(root, val));
    }
}
