package pratice.striver.DSAExperience.T12Tree.BinarySearchTree;

import pratice.common.Out;
import pratice.striver.DSAExperience.T12Tree.common.TreeNode;

import java.util.Stack;

public class TwoSumIvInputIsABst_easy_653 {
    static class Solution {
        static class BSTIterator {
            Stack<TreeNode> st = new Stack<>();
            boolean reverse = true;

            BSTIterator(TreeNode node, boolean isReverse) {
                this.reverse = isReverse;
                pushAll(node);
            }

            public int next() {
                TreeNode ref = st.pop();
                if (!reverse) pushAll(ref.right);
                else pushAll(ref.left);
                return ref.val;
            }


            public boolean hasNext() {
                return !st.isEmpty();
            }

            private void pushAll(TreeNode ref) {
                while (ref != null) {
                    st.push(ref);
                    if (reverse)
                        ref = ref.right;
                    else
                        ref = ref.left;
                }
            }
        }

        public boolean findTarget(TreeNode root, int k) {
            if (root == null) return false;
            BSTIterator left = new BSTIterator(root, false);
            BSTIterator right = new BSTIterator(root, true);

            int i = left.next();
            int j = right.next();//act like larger number

            while (i < j) {
                if (i + j == k) return true;
                else if (i + j < k) i = left.next();
                else j = right.next();
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = TreeNode.toTree(new Integer[]{7, 3, 15, null, null, 9, 20});
        int k = 18;
        Out.print(sol.findTarget(root, k));
    }
}
