package pratice.leetcode.blind75.T9Tree;

import pratice.common.Out;
import pratice.leetcode.blind75.T9Tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SubtreeOfAnotherTree_easy_572 {
    static class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if (root == null || subRoot == null) return root == null && subRoot == null;
            return isEqual(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        private boolean isEqual(TreeNode s, TreeNode t) {
            if (s == null || t == null) return s == null && t == null;
            return s.val == t.val && isEqual(s.left, t.left) && isEqual(s.right, t.right);
        }

        public boolean isSubtree2(TreeNode root, TreeNode subRoot) {
            if (root == null) return false;
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode curr = q.poll();
                    if (isEqual(curr, subRoot)) return true;
                    if (curr.left != null) q.offer(curr.left);
                    if (curr.right != null) q.offer(curr.right);
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree("3,4,5,1,2,null,null,null,null,0");
        TreeNode subRoot = TreeNode.toTree("4,1,2");
        Out.print(sol.isSubtree(root, subRoot));
        Out.print(sol.isSubtree2(root, subRoot));
    }
}
