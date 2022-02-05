package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.TreeNode;
import com.striver.DSAExperience.T12Tree.TreePair;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumWidth_medium_662 {
    static class Solution {
        // [Optimal] TC: O(n), O(n) - We are doing a simple level order traversal.
        // The inner loop simply traverses the nodes level-wise and does not add to the complexity.
        public int widthOfBinaryTree(TreeNode root) {
            int result = 0;
            if (root == null) return result;

            Queue<TreePair> q = new LinkedList<>();
            q.offer(new TreePair(root, 0));
            while (!q.isEmpty()) {
                int size = q.size();
                int mmin = q.peek().num;
                int first = 0, last = 0;
                for (int i = 0; i < size; i++) {
                    int idx = q.peek().num - mmin;
                    TreeNode node = q.poll().node;

                    if (i == 0) first = idx;
                    if (i == size - 1) last = idx;

                    if (node.left != null)
                        q.offer(new TreePair(node.left, 2 * idx + 1));
                    if (node.right != null)
                        q.offer(new TreePair(node.right, 2 * idx + 2));
                }
                result = Math.max(result, last - first + 1);
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{1, 3, 2, 5, 3, null, 9});
        Out.print(sol.widthOfBinaryTree(root));
    }
}
