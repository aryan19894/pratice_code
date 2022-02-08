package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal_easy_145 {
    //PREORDER: LEFT, RIGHT, ROOT
    static class Solution {
        // [Optimal Iterative1] TC: O(2n) - using first loop for n nodes and verify it returning to its parent
        // SC: O(n) - auxiliary stack space for recursive call
        public List<Integer> postorderTraversal3(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> st = new Stack<>();
            if (root == null) return res;

            TreeNode curr = root;
            while (curr != null || !st.isEmpty()) {
                if (curr != null) {
                    st.push(curr);
                    curr = curr.left;
                } else {
                    TreeNode temp = st.peek().right;
                    if (temp == null) {
                        temp = st.pop();
                        res.add(temp.val);
                        while (!st.isEmpty() && st.peek().right == temp) {
                            temp = st.pop();
                            res.add(temp.val);
                        }
                    } else
                        curr = temp;
                }
            }

            return res;
        }

        // [Optimal Iterative1] TC: O(2n) - using 2 stacks
        // SC: O(n) - auxiliary stack space for recursive call
        public List<Integer> postorderTraversal2(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> st1 = new Stack<>();
            Stack<TreeNode> st2 = new Stack<>();
            if (root == null) return res;

            st1.push(root);
            while (!st1.isEmpty()) {
                root = st1.pop();
                st2.push(root);
                if (root.left != null) st1.push(root.left);
                if (root.right != null) st1.push(root.right);
            }

            while (!st2.isEmpty())
                res.add(st2.pop().val);
            return res;
        }

        // [Optimal Recursive] TC: O(n) - no of nodes
        // SC: O(n) - auxiliary stack space for recursive call
        public List<Integer> postorderTraversal1(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            postOrder(root, res);
            return res;
        }

        private void postOrder(TreeNode root, List<Integer> res) {
            if (root == null) return;
            postOrder(root.left, res);
            postOrder(root.right, res);
            res.add(root.val);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> res = sol.postorderTraversal1(root);
        Out.print(res);

        res = sol.postorderTraversal2(root);
        Out.print(res);

        res = sol.postorderTraversal3(root);
        Out.print(res);
    }
}
