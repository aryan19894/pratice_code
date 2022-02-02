package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.TreeNode;

import java.util.ArrayList;

public class BoundaryOfBinaryTree_medium_545 {
    static class Solution {
        public ArrayList<Integer> traverseBoundary(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();

            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(15);
        root.right.right.right = new TreeNode(7);
        root.right.left.left = new TreeNode(15);
        root.right.left.right = new TreeNode(7);
        Out.print(sol.traverseBoundary(root));
    }
}
