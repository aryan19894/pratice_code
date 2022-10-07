package pratice.book.karumanchi.chapter6Tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class FindSize_6_7 {
    private static int findSizeRecursive(TreeNode root) {
        if (root == null) return 0;

        return 1 + findSizeRecursive(root.left) + findSizeRecursive(root.right);
    }

    private static int findSize(TreeNode root) {
        int count = 0;
        if (root == null) return count;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            count++;
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
        return count;
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

        System.out.println(findSizeRecursive(root));
        System.out.println(findSize(root));
    }


}
