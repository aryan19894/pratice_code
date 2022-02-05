package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.Node;
import com.striver.DSAExperience.T12Tree.TreeNode;

public class ChildrenSumProperty_Medium {
    static class Solution {
        // [Optimal] TC: O(n), O(n) - We are doing a simple level order traversal.
        // SC: O(N) - In the worst case( skewed tree), space complexity can be O(N).
        public void changeTree(Node root) {
            if (root == null) return;

            int child = 0;
            if (root.left != null) child += root.left.data;
            if (root.right != null) child += root.right.data;

            if (child >= root.data) root.data = child;
            else {
                if (root.left != null) root.left.data = root.data;
                if (root.right != null) root.right.data = root.data;
            }
            changeTree(root.left);
            changeTree(root.right);

            int total = 0;
            if (root.left != null) total += root.left.data;
            if (root.right != null) total += root.right.data;
            if (root.left != null || root.right != null)
                root.data = total;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        //TreeNode root = TreeNode.toTree(new Integer[]{40, 10, 20, 2, 5, 30, 40});
        Node root = Node.toTree(new Integer[]{50, 7, 2, 3, 5, 1, 30});
        sol.changeTree(root);
        Out.printTree(root);
    }
}
