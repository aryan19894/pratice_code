package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

import java.util.ArrayList;

public class PathToGivenNode_Easy {
    static class Solution {
        // [Optimal] TC: O(n), O(n) - use inOrder traversal
        public ArrayList<Integer> solve(TreeNode A, int B) {
            ArrayList<Integer> result = new ArrayList<Integer>();
            return findPath(A, B, result) ? result : new ArrayList<Integer>();
        }

        private boolean findPath(TreeNode node, int b, ArrayList<Integer> result) {
            if (node == null) return false;
            result.add(node.val);

            if (node.val == b) return true;

            if (findPath(node.left, b, result) ||
                    findPath(node.right, b, result))
                return true;

            result.remove(result.size() - 1);
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree("1 2 3 4 5 6 7");
        int B = 5;
        Out.print(sol.solve(root, B));
    }
}
