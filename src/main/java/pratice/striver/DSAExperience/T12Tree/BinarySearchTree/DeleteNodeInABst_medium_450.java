package pratice.striver.DSAExperience.T12Tree.BinarySearchTree;

import pratice.common.Out;
import pratice.striver.DSAExperience.T12Tree.common.TreeNode;

public class DeleteNodeInABst_medium_450 {
    static class Solution {
        // [Optimal] TC: O(H): Height of tree, O(1)
        public TreeNode deleteNode(TreeNode root, int key) {
            if (root == null) return null;
            if (root.val == key) return shift(root);

            TreeNode curr = root;
            while (curr != null) {
                if (curr.val > key) {
                    if (curr.left != null && curr.left.val == key) {
                        curr.left = shift(curr.left);
                        break;
                    } else
                        curr = curr.left;
                } else {
                    if (curr.right != null && curr.right.val == key) {
                        curr.right = shift(curr.right);
                        break;
                    } else
                        curr = curr.right;
                }
            }
            return root;
        }

        private TreeNode shift(TreeNode node) {
            if (node.left == null) return node.right;
            else if (node.right == null) return node.left;
            else {
                TreeNode lastRight = findLastRight(node.left);
                lastRight.right = node.right;
                return node.left;
            }
        }

        private TreeNode findLastRight(TreeNode node) {
            if (node.right == null) return node;
            return findLastRight(node.right);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{8, 5, 12, 2, 7, 10, 13, 1, 3, 6, 8, null, null, null, null,
                null, null, null, 4});
        int key = 5;
        Out.print(sol.deleteNode(root, key));
    }
}
