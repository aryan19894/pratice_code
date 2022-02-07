package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromInPostOrder_medium_106 {
    static class Solution {
        // [Optimal] TC: O(n), O(n) - assign index for each node. postorder last element must be its root element
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (inorder == null || postorder == null || inorder.length != postorder.length)
                return null;
            Map<Integer, Integer> index = new HashMap<>();
            for (int i = 0; i < inorder.length; i++)
                index.put(inorder[i], i);

            return buildTree(inorder, 0, inorder.length - 1,
                    postorder, 0, postorder.length - 1, index);
        }

        private TreeNode buildTree(int[] inorder, int inStart, int inEnd,
                                   int[] postorder, int postStart, int postEnd,
                                   Map<Integer, Integer> index) {
            if (postStart > postEnd || inStart > inEnd)
                return null;

            TreeNode root = new TreeNode(postorder[postEnd]);
            int inRoot = index.get(root.val);

            root.left = buildTree(inorder, inStart, inRoot - 1,
                    postorder, postStart, postStart + inRoot - inStart - 1, index);
            root.right = buildTree(inorder, inRoot + 1, inEnd,
                    postorder, postStart + inRoot - inStart, postEnd - 1, index);

            return root;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
//        int[] inorder = {9, 3, 15, 20, 7};
//        int[] postorder = {9, 15, 7, 20, 3};
        int[] inorder = {40, 20, 50, 10, 60, 30};
        int[] postorder = {40, 50, 20, 60, 30, 10};
        Out.printTree(sol.buildTree(inorder, postorder));
    }
}
