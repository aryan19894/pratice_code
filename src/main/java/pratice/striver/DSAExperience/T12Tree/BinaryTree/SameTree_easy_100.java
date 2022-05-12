package pratice.striver.DSAExperience.T12Tree.BinaryTree;

import pratice.common.Out;
import pratice.striver.DSAExperience.T12Tree.common.TreeNode;

public class SameTree_easy_100 {
    static class Solution {
        // [Optimal] TC: O(n) - we're traversing each node in same direction 1by1
        // SC: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree )
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null || q == null) return p == q;

            return (p.val == q.val) &&
                    isSameTree(p.left, q.left) &&
                    isSameTree(p.right, q.right);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(5);

        Out.print(sol.isSameTree(root1, root2));
    }
}
