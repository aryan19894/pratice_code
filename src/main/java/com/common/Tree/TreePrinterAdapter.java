package com.common.Tree;

import com.striver.DSAExperience.T12Tree.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

class TreeNodeAdapter implements TreePrinter<TreeNode> {

    @Override
    public void printRoot(TreeNode node) {
        System.out.println(node);
    }

    @Override
    public void print(TreeNode root) {
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
