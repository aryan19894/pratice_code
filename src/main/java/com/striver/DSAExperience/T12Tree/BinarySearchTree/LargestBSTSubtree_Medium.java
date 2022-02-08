package com.striver.DSAExperience.T12Tree.BinarySearchTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;



public class LargestBSTSubtree_Medium {
    static class Solution {
        static class NodeVal {
            int max, min, size;

            public NodeVal(int min, int max, int size) {
                this.max = max;
                this.min = min;
                this.size = size;
            }
        }
        public static int largestBST(TreeNode<Integer> root) {
            return largestBSTHelper(root).size;
        }

        private static NodeVal largestBSTHelper(TreeNode<Integer> root) {
            if (root == null)
                return new NodeVal(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

            NodeVal left = largestBSTHelper(root.left);
            NodeVal right = largestBSTHelper(root.right);

            if (root.data > left.max && root.data < right.min)
                return new NodeVal(Math.min(root.data, left.min),
                        Math.max(root.data, right.max),
                        1 + left.size + right.size);

            return new NodeVal(Integer.MIN_VALUE, Integer.MAX_VALUE,
                    Math.max(left.size, right.size));
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode<Integer> root = TreeNode.toTree("5 2 4 1 3 -1 -1 -1 -1 -1 -1");

        Out.print(sol.largestBST(root));
    }
}
