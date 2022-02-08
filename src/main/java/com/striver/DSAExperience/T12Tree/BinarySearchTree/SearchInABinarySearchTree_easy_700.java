package com.striver.DSAExperience.T12Tree.BinarySearchTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

public class SearchInABinarySearchTree_easy_700 {
    static class Solution {
        // [Optimal] TC: O(logN), O(1) - use rule of BST
        public TreeNode searchBST(TreeNode root, int val) {
            while (root != null && root.val != val)
                root = root.val > val ? root.left : root.right;
            return root;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{8, 5, 12, 4, 7, 10, 14, null, null, 6, null, null, null, 13});
        int val = 17;
        Out.print(sol.searchBST(root, val));
    }
}
