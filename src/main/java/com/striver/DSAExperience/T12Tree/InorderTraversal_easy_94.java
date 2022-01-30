package com.striver.DSAExperience.T12Tree;

import com.common.Out;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal_easy_94 {
    static class Solution {
        // [Optimal Iterative] TC: O(n) - using stack to keep track from its parent and traverse each node 1by1
        // SC: O(n) - auxiliary stack space for recursive call
        public List<Integer> inorderTraversal1(TreeNode current) {
            List<Integer> res = new ArrayList<Integer>();
            Stack<TreeNode> stack = new Stack<>();
            while (true) {
                if (current != null) {
                    stack.push(current);
                    current = current.left;
                } else {
                    if (stack.isEmpty()) break;
                    current = stack.pop();
                    res.add(current.val);
                    current = current.right;
                }
            }
            return res;
        }

        // [Optimal Recursive] TC: O(n) - no of nodes
        // SC: O(n) - auxiliary stack space for recursive call
        public List<Integer> inorderTraversal2(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            inOrder(root, res);
            return res;
        }

        //left, root, right
        //Recursive
        private void inOrder(TreeNode current, List<Integer> res) {
            if (current == null) return;

            inOrder(current.left, res);
            res.add(current.val);
            inOrder(current.right, res);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Solution sol = new Solution();
        List<Integer> res = sol.inorderTraversal1(root);
        Out.print(res);
        res = sol.inorderTraversal2(root);
        Out.print(res);
    }
}
