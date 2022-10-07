package pratice.book.karumanchi.chapter6Tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SearchElement_3_4 {
    private static boolean searchElementRecursive(TreeNode root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;
        return searchElementRecursive(root.left, key) || searchElementRecursive(root.right, key);
    }

    private static boolean searchElement(TreeNode root, int key) {
        if (root == null) return false;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.data == key) return true;
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
        return false;
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

        System.out.println(searchElementRecursive(root, 13));
        System.out.println(searchElement(root, 13));
    }


}
