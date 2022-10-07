package pratice.book.karumanchi.chapter6Tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class FindMaxElement_1_2 {
    private static int maxElementRecursive(TreeNode root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.data, Math.max(maxElementRecursive(root.left), maxElementRecursive(root.right)));
    }

    private static int maxElement(TreeNode root) {
        int max = Integer.MIN_VALUE;
        if (root == null) return max;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            max = Math.max(max, curr.data);
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(11);
//        root.left.left = new BinaryTreeNode(17);
//        root.left.left.left = new BinaryTreeNode(13);
//        root.left.left.left.left = new BinaryTreeNode(1);

        root.right = new TreeNode(11);
//        root.right.left = new BinaryTreeNode(51);
//        root.right.right = new BinaryTreeNode(4);
//        root.right.left.left = new BinaryTreeNode(8);
//        root.right.left.right = new BinaryTreeNode(9);
//        root.right.left.left.left = new BinaryTreeNode(11);

        System.out.println(maxElementRecursive(root));
        System.out.println(maxElement(root));
    }


}
