package pratice.striver.DSAExperience.T12Tree.BinaryTree;

import pratice.common.Out;
import pratice.striver.DSAExperience.T12Tree.common.TreeNode;

import java.util.ArrayList;

public class BoundaryTraversal_medium_545 {
    static class Solution {
        // [Optimal] TC: O(n) - O(H) + O(H) + O(N) - right and left height level transversal
        // SC: O(1) Extra Space + O(H) Recursion Stack space (Where “H”  is the height of binary tree )
        public ArrayList<Integer> traverseBoundary(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            if (!isLeaf(root)) result.add(root.val);

            addLeftBoundary(root, result);
            addLeaves(root, result);
            addRightBoundary(root, result);
            return result;
        }

        private void addRightBoundary(TreeNode root, ArrayList<Integer> result) {
            TreeNode curr = root.right;
            ArrayList<Integer> tmp = new ArrayList<>();
            while (curr != null) {
                if (!isLeaf(curr)) tmp.add(curr.val);
                if (curr.right != null) curr = curr.right;
                else curr = curr.left;
            }

            for (int i = tmp.size() - 1; i >= 0; i--)
                result.add(tmp.get(i));
        }

        private void addLeaves(TreeNode root, ArrayList<Integer> result) {
            if (isLeaf(root)) {
                result.add(root.val);
                return;
            }

            if (root.left != null) addLeaves(root.left, result);
            if (root.right != null) addLeaves(root.right, result);
        }

        private void addLeftBoundary(TreeNode root, ArrayList<Integer> result) {
            TreeNode curr = root.left;
            while (curr != null) {
                if (!isLeaf(curr)) result.add(curr.val);
                if (curr.left != null) curr = curr.left;
                else curr = curr.right;
            }
        }

        private boolean isLeaf(TreeNode root) {
            return root.left == null && root.right == null;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);

        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);
        Out.print(sol.traverseBoundary(root));
    }
}
