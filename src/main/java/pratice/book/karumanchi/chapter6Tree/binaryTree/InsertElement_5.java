package pratice.book.karumanchi.chapter6Tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InsertElement_5 {
    private static TreeNode insertElementRecursive(TreeNode root, int data) {
        if (root == null) return new TreeNode(data);

        TreeNode currLeft = insertElementRecursive(root.left, data);
        if (currLeft != null)
            root.left = currLeft;
        else {
            TreeNode currRight = insertElementRecursive(root.right, data);
            if (currRight != null)
                root.right = currRight;
        }

        return root;
    }

    private static TreeNode insertElement(TreeNode root, int data) {
        if (root == null) return new TreeNode(data);

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.left == null) {
                curr.left = new TreeNode(data);
                return root;
            } else q.offer(curr.left);
            if (curr.right == null) {
                curr.right = new TreeNode(data);
                return root;
            } else q.offer(curr.right);
        }
        return root;
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

        insertElement(root, 8).print();
        System.out.println("------");
        insertElementRecursive(root, 13).print();
    }


}
