package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.striver.DSAExperience.T12Tree.TreeNode;

public class BalancedBinaryTree_easy_110 {
	static class Solution {
	    public boolean isBalanced(TreeNode root) {
	        return false;
	    }
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		System.out.println(sol.isBalanced(root));
	}
}
