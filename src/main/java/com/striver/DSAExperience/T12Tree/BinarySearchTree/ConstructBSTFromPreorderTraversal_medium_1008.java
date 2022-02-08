package com.striver.DSAExperience.T12Tree.BinarySearchTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConstructBSTFromPreorderTraversal_medium_1008 {
    static class Solution {
        // [Better] TC: O(NlogN)+O(N) - nlogN is for sorting the preorder O(N) is for create BST
        // SC: O(N): inorder array
        public TreeNode bstFromPreorder(int[] preorder) {
            int[] inorder = sort(Arrays.copyOf(preorder, preorder.length));
            Map<Integer, Integer> index = new HashMap<>();
            for (int i = 0; i < inorder.length; i++)
                index.put(inorder[i], i);

            return buildTree(preorder, 0, preorder.length - 1,
                    inorder, 0, inorder.length - 1, index);
        }

        private TreeNode buildTree(int[] preorder, int preStart, int preEnd,
                                   int[] inorder, int inStart, int inEnd,
                                   Map<Integer, Integer> index) {
            if (preStart > preEnd || inStart > inEnd) return null;

            TreeNode root = new TreeNode(preorder[preStart]);
            int interval = index.get(root.val);

            root.left = buildTree(preorder, preStart + 1, preStart + interval - inStart,
                    inorder, inStart, interval - 1, index);

            root.right = buildTree(preorder, preStart + interval - inStart + 1, preEnd,
                    inorder, interval + 1, inEnd, index);

            return root;
        }

        private int[] sort(int[] preorder) {
            Arrays.sort(preorder);
            return preorder;
        }

        // [Optimal] TC: O(3N), O(1) - follow the upper bound rule of BST
        public TreeNode bstFromPreorder2(int[] preorder) {
            return buildBST(preorder, Integer.MAX_VALUE, new int[]{0});
        }

        private TreeNode buildBST(int[] preorder, int ub, int[] idx) {
            if (idx[0] == preorder.length || preorder[idx[0]] > ub) return null;

            TreeNode root = new TreeNode(preorder[idx[0]++]);
            root.left = buildBST(preorder, root.val, idx);
            root.right = buildBST(preorder, ub, idx);

            return root;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] preorder = {8, 5, 1, 7, 10, 12};
        Out.print(sol.bstFromPreorder2(preorder));
    }
}
