package pratice.leetcode.blind75.T9Tree;

import pratice.common.Out;
import pratice.leetcode.blind75.T9Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class KthSmallestElementInABst_medium_230 {
    static class Solution {
        public int kthSmallest(TreeNode root, int k) {
            List<Integer> res = new ArrayList<Integer>();
            inorder(root, k, res);
            return res.get(k - 1);
        }

        private void inorder(TreeNode root, int k, List<Integer> res) {
            if (root == null || res.size() == k) return;

            inorder(root.left, k, res);
            res.add(root.val);
            inorder(root.right, k, res);
        }

        public int kthSmallest2(TreeNode root, int k) {
            List<Integer> res = new ArrayList<Integer>();
            Stack<TreeNode> st = new Stack<>();

            while (true) {
                if (root != null) {
                    st.push(root);
                    root = root.left;
                } else {
                    if (st.isEmpty()) break;
                    root = st.pop();
                    res.add(root.val);
                    root = root.right;
                }

                if (res.size() == k) break;
            }
            return res.get(k - 1);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree("5,3,6,2,4,null,null,1");
        int k = 3;
        Out.print(sol.kthSmallest(root, k));
        Out.print(sol.kthSmallest2(root, k));
    }
}
