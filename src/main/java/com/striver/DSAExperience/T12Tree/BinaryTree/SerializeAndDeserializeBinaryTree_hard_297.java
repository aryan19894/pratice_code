package com.striver.DSAExperience.T12Tree.BinaryTree;

import com.common.Out;
import com.striver.DSAExperience.T12Tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class Codec {

    // [Optimal] TC: O(n), O(n) - combine node value as string
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        StringBuilder res = new StringBuilder();

        while (!q.isEmpty()) {
            TreeNode ref = q.poll();
            if (ref == null) {
                res.append("n,");
                continue;
            }
            res.append(ref.val+",");
            q.offer(ref.left);
            q.offer(ref.right);
        }
        return res.toString();
    }

    // [Optimal] TC: O(n), O(n) - decoupled the string with delimiter
    public TreeNode deserialize(String data) {
        if (data == null) return null;

        String[] input = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(input[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int i = 1;
        while (!queue.isEmpty() && i < input.length) {
            TreeNode curr = queue.poll();
            String currVal = input[i++];

            if (!currVal.equals("#")) {
                curr.left = new TreeNode(Integer.parseInt(currVal));
                queue.offer(curr.left);
            }

            if (i >= input.length) break;

            currVal = input[i++];
            if (!currVal.equals("#")) {
                curr.right = new TreeNode(Integer.parseInt(currVal));
                queue.offer(curr.right);
            }
        }
        return root;
    }
}

public class SerializeAndDeserializeBinaryTree_hard_297 {
    public static void main(String[] args) {
        Codec c = new Codec();
        TreeNode root = TreeNode.toTree(new Integer[]{1, 2, 13, null, null, 4, 5});

        String out = c.serialize(root);
        System.out.println(out);

        Out.print(c.deserialize(out));
    }
}
