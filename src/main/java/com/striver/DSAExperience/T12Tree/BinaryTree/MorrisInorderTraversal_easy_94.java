package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MorrisInorderTraversal_easy_94 {
    static class Solution {
        // [Optimal Iterative] TC: O(n) - Morris rule for inorder: we will traverse in constant space
        // SC: O(1)
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();

            TreeNode current = root;
            while (current != null) {
                if (current.left == null) { // 1st Case: if there is no node in left subtree
                    res.add(current.val);
                    current = current.right;
                } else { // 2nd Case: left subtree is available
                    TreeNode prev = current.left;
                    //moving to rightmost element of left subtree
                    while (prev.right != null && prev.right != current)
                        prev = prev.right;

                    //If rightmost element become null: create the thread to previous root node
                    if (prev.right == null) {
                        prev.right = current;
                        current = current.left;
                    } else { //If thread is already available: means left subtree is already visited, break that thread
                        prev.right = null;
                        res.add(current.val); // adding to result cause left subtree is already visited, now it moved to root
                        current = current.right;
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.toTree(new Integer[]{1, null, 2, 3});

        Solution sol = new Solution();
        List<Integer> res = sol.inorderTraversal(root);
        Out.print(res);
    }
}
