package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MorrisPreorderTraversal_easy_144 {
    static class Solution {

        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();

            TreeNode curr = root;
            while (curr != null) {
                if (curr.left == null) { // 1st Case: if there is no node in left subtree
                    res.add(curr.val);
                    curr = curr.right;
                } else { // 2nd Case: left subtree is available
                    TreeNode prev = curr.left;
                    //moving to rightmost element of left subtree
                    while (prev.right != null && prev.right != curr)
                        prev = prev.right;

                    //If rightmost element become null: create the thread to previous root node
                    if (prev.right == null) {
                        prev.right = curr;
                        res.add(curr.val); // adding to result because we are aware that thread is created to its root
                        curr = curr.left;
                    } else { //If thread is already available: means left subtree is already visited, break that thread
                        prev.right = null;
                        curr = curr.right;
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeNode.toTree(new Integer[]{1, null, 2, 3});

        Solution sol = new Solution();
        List<Integer> res = sol.preorderTraversal(root);
        Out.print(res);
    }
}
