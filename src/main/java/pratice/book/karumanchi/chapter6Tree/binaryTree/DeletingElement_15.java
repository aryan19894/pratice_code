package pratice.book.karumanchi.chapter6Tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DeletingElement_15 {
    private static void deleteNode(TreeNode root, int key) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode lastNode = findLastNode(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();
            if (curr.data == key) {
                curr.data = lastNode.data;
            }

            if (curr.left != null) {
                q.offer(curr.left);
                if (curr.left.equals(lastNode)) {
                    curr.left = null;
                    return;
                }
            }
            if (curr.right != null) {
                q.offer(curr.right);
                if (curr.right.equals(lastNode)) {
                    curr.right = null;
                    return;
                }
            }
        }
    }

    private static TreeNode findLastNode(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        TreeNode curr = null;
        while (!q.isEmpty()) {
            curr = q.poll();
            if (curr.left != null) q.offer(curr.left);
            if (curr.right != null) q.offer(curr.right);
        }
        return curr;
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

        deleteNode(root, 8);
        root.print();
    }

}
