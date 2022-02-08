package com.striver.DSAExperience.T12Tree.BinarySearchTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

public class MaximumSumBSTInBinaryTree_hard_1373 {
    static class Solution {
        static class NodeVal {
            int max, min, size;

            public NodeVal(int max, int min, int size) {
                this.max = max;
                this.min = min;
                this.size = size;
            }
        }

        public int maxSumBST(TreeNode root) {
            return maxSumBSTHelper(root).size;
        }

        private NodeVal maxSumBSTHelper(TreeNode root) {
            if (root == null)
                return new NodeVal(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

            NodeVal left = maxSumBSTHelper(root.left);
            NodeVal right = maxSumBSTHelper(root.right);

            if (root.val < left.min && root.val > right.max)
                return new NodeVal(Math.min(root.val, left.min),
                        Math.max(root.val, right.max),
                        1 + left.size + right.size);

            return new NodeVal(Integer.MIN_VALUE, Integer.MAX_VALUE,
                    Math.max(left.size, right.size));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6});
        Out.print(sol.maxSumBST(root));
    }
}
