package pratice.leetcode.blind75.T9Tree;

import pratice.common.Out;
import pratice.leetcode.blind75.T9Tree.common.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal_medium_105 {
    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> idx = new HashMap<>();
            for (int i = 0; i < inorder.length; i++)
                idx.put(inorder[i], i);

            return build(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, idx);
        }

        private TreeNode build(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd,
                               Map<Integer, Integer> idx) {
            if (preStart > preEnd || inStart > inEnd) return null;

            TreeNode root = new TreeNode(preorder[preStart]);
            int rootIdx = idx.get(root.val);
            int childLen = rootIdx - inStart;

            root.left = build(preorder, preStart + 1, preStart + childLen,
                    inorder, inStart, rootIdx - 1, idx);
            root.right = build(preorder, preStart + childLen + 1, preEnd,
                    inorder, rootIdx + 1, inEnd, idx);
            return root;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode.print(sol.buildTree(preorder, inorder));
    }
}
