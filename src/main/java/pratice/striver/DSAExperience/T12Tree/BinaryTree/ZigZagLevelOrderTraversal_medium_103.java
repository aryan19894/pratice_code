package pratice.striver.DSAExperience.T12Tree.BinaryTree;

import pratice.common.Out;
import pratice.striver.DSAExperience.T12Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal_medium_103 {
    static class Solution {
		// [Optimal Iterative] TC: O(n) - using queue to keep track from its children w.r.t levels and
		// updating element to sublist with flag value 0 - left to right, 1- right to left
		// SC: O(n) - result list and queue
		public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if(root == null) return result;

            Queue<TreeNode> q = new LinkedList<>();
            boolean flag = true;

            q.offer(root);
            while (!q.isEmpty()) {
                int size = q.size();
                List<Integer> subList = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    TreeNode ref = q.poll();
                    if (ref.left != null) q.offer(ref.left);
                    if (ref.right != null) q.offer(ref.right);

                    if (!flag)
                        subList.add(0, ref.val);
                    else
                        subList.add(ref.val);
                }
                result.add(subList);
				flag = !flag;
            }
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
		Out.print(sol.zigzagLevelOrder(root));
    }
}
