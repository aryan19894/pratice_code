package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList_medium_114 {
    static class Solution {
        static TreeNode prev = null;

        // [Optimal Recursive] TC: O(n), O(n) - calling all nodes and linked them with right subtree
        public void flatten(TreeNode root) {
            if (root == null) return;

            flatten(root.right);
            flatten(root.left);

            root.right = prev;
            root.left = null;
            prev = root;
        }

        // [Optimal Iterative1] TC: O(n), O(n) - using stack
        public void flatten2(TreeNode root) {
            Stack<TreeNode> st = new Stack<>();
            if (root == null) return;

            st.push(root);
            while (!st.isEmpty()) {
                TreeNode curr = st.pop();
                if (curr.right != null) st.push(curr.right);
                if (curr.left != null) st.push(curr.left);

                if (!st.isEmpty())
                    curr.right = st.peek();
                curr.left = null;
            }
        }

        // [Optimal Iterative2] TC: O(n), O(1) - using morris traversal with thread binary tree
        public void flatten3(TreeNode root) {
            if (root == null) return;

            TreeNode curr = root;
            while (curr != null) {
                if (curr.left != null) {
                    TreeNode prev = curr.left;
                    while (prev.right != null)
                        prev = prev.right;

                    prev.right = curr.right;
                    curr.right = curr.left;
                    curr.left = null;
                }
                curr = curr.right;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{1, 2, 5, 3, 4, null, 6, null, null, null, null, 7});
        sol.flatten(root);
        Out.print(root);

        root = TreeNode.toTree(new Integer[]{1, 2, 5, 3, 4, null, 6, null, null, null, null, 7});
        sol.flatten2(root);
        Out.print(root);

        root = TreeNode.toTree(new Integer[]{1, 2, 5, 3, 4, null, 6, null, null, null, null, 7});
        sol.flatten3(root);
        Out.print(root);
    }
}
