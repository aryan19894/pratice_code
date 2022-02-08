package com.striver.DSAExperience.T12Tree.BinarySearchTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

public class MaximumSumBSTInBinaryTree_hard_1373 {
    static class Solution {
        static class NodeVal {
            int max, min, sum;

            public NodeVal(int min, int max, int sum) {
                this.max = max;
                this.min = min;
                this.sum = sum;
            }
        }

        public int maxSumBST(TreeNode root) {
            NodeVal nodeVal = new NodeVal(0, 0, 0);
            maxSumBSTHelper(root, nodeVal);
            return nodeVal.sum < 0 ? 0 : nodeVal.sum;
        }

        private NodeVal maxSumBSTHelper(TreeNode root, NodeVal ans) {
            if (root == null)
                return new NodeVal(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

            NodeVal left = maxSumBSTHelper(root.left, ans);
            NodeVal right = maxSumBSTHelper(root.right, ans);

            if (left.max < root.val && root.val < right.min) {
                int currentSum = root.val + left.sum + right.sum;
                ans.sum = Math.max(ans.sum, currentSum);

                return new NodeVal(Math.min(root.val, left.min),
                        Math.max(root.val, right.max),
                        currentSum);
            }
            return new NodeVal(Integer.MIN_VALUE, Integer.MAX_VALUE,
                    Math.max(left.sum, right.sum));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6});
        Out.print(sol.maxSumBST(root));
    }
}
