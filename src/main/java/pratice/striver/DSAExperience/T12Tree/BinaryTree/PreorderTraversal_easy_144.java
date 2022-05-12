package pratice.striver.DSAExperience.T12Tree.BinaryTree;

import pratice.common.Out;
import pratice.striver.DSAExperience.T12Tree.common.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal_easy_144 {
    //PREORDER: ROOT, LEFT, RIGHT
    static class Solution {
        // [Optimal Iterative] TC: O(n) - using stack to keep track from its parent and traverse each node 1by1
        // SC: O(n) - auxiliary stack space for recursive call
        public List<Integer> preorderTraversal1(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            if (root == null)
                return res;
            Stack<TreeNode> st = new Stack<>();
            st.push(root);

            while (!st.isEmpty()) {
                TreeNode topNode = st.pop();
                res.add(topNode.val);

                //we will push first right then left: LIFO follow the stack
                if (topNode.right != null) st.push(topNode.right);
                if (topNode.left != null) st.push(topNode.left);
            }
            return res;
        }

        // [Optimal Recursive] TC: O(n) - no of nodes
        // SC: O(n) - auxiliary stack space for recursive call
        public List<Integer> preorderTraversal2(TreeNode root) {
            List<Integer> res = new ArrayList<Integer>();
            preOrder(root, res);
            return res;
        }

        //root, left, right
        //Recursive
        private void preOrder(TreeNode current, List<Integer> res) {
            if (current == null) return;

            res.add(current.val);
            preOrder(current.left, res);
            preOrder(current.right, res);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> res = sol.preorderTraversal1(root);
        Out.print(res);

        res = sol.preorderTraversal2(root);
        Out.print(res);
    }
}
