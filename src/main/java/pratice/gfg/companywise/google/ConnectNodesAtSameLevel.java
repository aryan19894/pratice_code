package pratice.gfg.companywise.google;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodesAtSameLevel {
    static class Node {
        int data;
        Node left;
        Node right;
        Node nextRight;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
            nextRight = null;
        }
    }

    static public class Solution {
        public void connect(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.offer(root);

            while (!q.isEmpty()) {
                int size = q.size() - 1;
                Node curr = q.poll();
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
                for (int i = 0; i < size; i++) {
                    curr.nextRight = q.poll();
                    curr = curr.nextRight;

                    if (curr.left != null) q.offer(curr.left);
                    if (curr.right != null) q.offer(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node root = new Node(10);
        root.left = new Node(20);
        root.left.left = new Node(40);
        root.left.right = new Node(60);
        root.right = new Node(30);
//        root.right.left = new Node(50);
//        root.right.right = new Node(70);

        sol.connect(root);
        //Out.print(sol.connect(root));
    }
}
