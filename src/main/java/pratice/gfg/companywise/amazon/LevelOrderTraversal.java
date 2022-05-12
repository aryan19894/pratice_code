package pratice.gfg.companywise.amazon;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    static class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static ArrayList<Integer> levelOrder(Node node) {
        ArrayList<Integer> result = new ArrayList();
        Queue<Node> q = new LinkedList<>();

        if (node == null) return result;
        q.offer(node);
        while (!q.isEmpty()) {
            List<Integer> subList = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node ref = q.poll();

                if (ref.left != null)
                    q.offer(ref.left);
                if (ref.right != null)
                    q.offer(ref.right);

                subList.add(ref.data);
            }
            result.addAll(subList);
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right = new Node(3);
        root.right.left = new Node(6);
        root.right.left.right = new Node(8);

        root.right.right = new Node(7);
        root.right.right.right = new Node(9);

        Out.print(levelOrder(root));
    }
}
