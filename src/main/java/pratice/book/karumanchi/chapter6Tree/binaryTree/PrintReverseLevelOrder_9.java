package pratice.book.karumanchi.chapter6Tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintReverseLevelOrder_9 {
    private static void printReverseLevelOrder(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> st = new Stack<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
            st.push(curr);
        }

        while (!st.isEmpty())
            System.out.print(st.pop().data + " ");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(11);
        root.left.left = new TreeNode(17);
        root.left.left.left = new TreeNode(13);
        root.left.left.left.left = new TreeNode(1);

        root.right = new TreeNode(11);
        root.right.left = new TreeNode(51);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(8);
        root.right.left.right = new TreeNode(9);
        root.right.left.left.left = new TreeNode(11);

        printReverseLevelOrder(root);
    }


}
