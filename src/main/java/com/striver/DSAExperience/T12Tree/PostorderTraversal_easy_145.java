package com.striver.DSAExperience.T12Tree;

import com.common.Out;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal_easy_145 {
	//PREORDER: LEFT, RIGHT, ROOT
	static class Solution {
		// [Optimal Recursive] TC: O(n) - no of nodes
		// SC: O(n) - auxiliary stack space for recursive call
		public List<Integer> postorderTraversal(TreeNode root) {
			List<Integer> res = new ArrayList<>();
			postOrder(root, res);
			return res;
	    }

		private void postOrder(TreeNode root, List<Integer> res) {
			if(root == null) return;
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

		List<Integer> res = sol.postorderTraversal(root);
		Out.print(res);
	}
}
