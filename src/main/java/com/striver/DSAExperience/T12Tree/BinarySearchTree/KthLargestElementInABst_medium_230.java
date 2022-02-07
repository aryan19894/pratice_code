package com.striver.DSAExperience.T12Tree.BinarySearchTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.TreeNode;

public class KthLargestElementInABst_medium_230 {
    static class Solution {
        // Inorder traversal in BST is already sorted
        // [Optimal: Recursive] TC: O(N), O(N)
        // [Optimal: Iterative] TC: O(N), O(N)
        // [Optimal: Morrison] TC: O(N), O(1): using morrison traversal
        public int kthLargest(TreeNode root, int k) {
            k = size(root) - k;
            TreeNode curr = root;
            int ans = 0;
            while (curr != null) {
                if (curr.left == null) {
                    k--;
                    ans = curr.val;
                    curr = curr.right;
                } else {
                    TreeNode prev = curr.left;
                    while (prev.right != null && prev.right != curr)
                        prev = prev.right;

                    if (prev.right == null) {
                        prev.right = curr;
                        curr = curr.left;
                    } else {
                        prev.right = null;
                        k--;
                        ans = curr.val;
                        curr = curr.right;
                    }
                }
                if (k == 0)
                    return ans;
            }
            return -1;
        }

        private int size(TreeNode root) {
            if (root == null) return 0;
            return 1 + size(root.left) + size(root.right);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{5, 3, 7, 1, 4, 6, 8, null, 2});
        int k = 3;
        Out.print(sol.kthLargest(root, k));
    }
}
