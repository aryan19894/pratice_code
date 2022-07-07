package pratice.leetcode.blind75.T9Tree;

import pratice.common.Out;
import pratice.leetcode.blind75.T9Tree.common.TreeNode;

public class SameTree_easy_100 {
    static class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null) return p == q;
            return (p.val == q.val) &&
                    isSameTree(p.left, q.left) &&
                    isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode p = TreeNode.toTree("1,2,1");
        TreeNode q = TreeNode.toTree("1,1,2");
        Out.print(sol.isSameTree(p, q));
    }
}
