package pratice.leetcode.blind75.T9Tree;

import pratice.common.Out;
import pratice.leetcode.blind75.T9Tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return null;

        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode ref = q.poll();
            if (ref != null) {
                sb.append(ref.val + "|");
                q.offer(ref.left);
                q.offer(ref.right);
            } else {
                sb.append("@|");
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null) return null;

        String[] input = data.split("\\|");
        TreeNode root = new TreeNode(Integer.parseInt(input[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;
        while (!q.isEmpty() && i < data.length()) {
            TreeNode curr = q.poll();
            String currVal = input[i++];

            if (!currVal.equals("@")) {
                curr.left = new TreeNode(Integer.parseInt(currVal));
                q.offer(curr.left);
            }

            if (i >= data.length()) break;

            currVal = input[i++];
            if (!currVal.equals("@")) {
                curr.right = new TreeNode(Integer.parseInt(currVal));
                q.offer(curr.right);
            }
        }
        return root;
    }
}

public class SerializeAndDeserializeBinaryTree_hard_297 {
    public static void main(String[] args) {
        Codec c = new Codec();
        TreeNode root = TreeNode.toTree("1,2,3,null,null,4,5");

        String data = c.serialize(root);
        System.out.println(data);
        root = c.deserialize(data);
        TreeNode.print(root);
    }
}
