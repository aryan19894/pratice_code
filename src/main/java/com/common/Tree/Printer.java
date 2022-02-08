package com.common.Tree;

import com.striver.DSAExperience.T12Tree.common.GlobalNode;
import com.striver.DSAExperience.T12Tree.common.TestNode;

import java.util.LinkedList;
import java.util.Queue;

public class Printer {
    public static void print(Object root) {
        Queue<Object> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int levelNum = q.size();
            for (int i = 0; i < levelNum; i++) {
                GlobalNode ref = (GlobalNode) q.poll();
                if (ref != null) {
                    q.offer(ref.left);
                    q.offer(ref.right);
                    System.out.print(ref);
                } else
                    System.out.print("null ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        //TreeNode root = TreeNode.toTree(new Integer[]{8, 5, 12, 4, 7, 10, 14, null, null, 6, null, null, null, 13});
        //Node root = Node.toTree(new Integer[]{8, 5, 12, 4, 7, 10, 14});
        //TreeNode root = TreeNode.toTree(new Integer[]{8, 5, 12, 4, 7, 10, 14, null, null, 6, null, null, null, 13});
        TestNode root = new TestNode(1);
        root.right = new TestNode(2);
        root.right.left = new TestNode(3);

        Printer.print(root);

    }
}
