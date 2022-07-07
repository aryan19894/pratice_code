package pratice.leetcode.blind75.T9Tree.common;

import pratice.common.converter.Str;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode toTree(String input) {
        Integer[] ip = Str.toArray(input);

        if (ip.length == 0 || ip[0] == -1)
            return null;

        TreeNode root = new TreeNode(ip[0]);
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        for (int i = 1; i < ip.length && !q.isEmpty(); i++) {
            TreeNode currNode = q.poll();
            if (ip[i] != null) {
                currNode.left = new TreeNode(ip[i]);
                q.add(currNode.left);
            }
            ++i;
            if (i < ip.length && ip[i] != null) {
                currNode.right = new TreeNode(ip[i]);
                q.add(currNode.right);
            }
        }
        return root;
    }

    public static void print(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            for (int i = 0; i < levelNum; i++) {
                TreeNode ref = q.poll();
                if (ref != null) {
                    q.offer(ref.left);
                    q.offer(ref.right);
                    System.out.print(ref.val + " ");
                } else
                    System.out.print("null ");
            }
            System.out.println();
        }
    }
}
