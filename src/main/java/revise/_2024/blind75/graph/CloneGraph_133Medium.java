package revise._2024.blind75.graph;

import java.util.*;

public class CloneGraph_133Medium {
    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        public void addNeighbour(Node... nodes) {
            for (Node n : nodes)
                this.neighbors.add(n);
        }
    }

    static Node cloneGraph(Node node) {
        if (node == null) return node;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node, new Node(node.val));

        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node neigh : curr.neighbors) {
                if (!map.containsKey(neigh)) {
                    map.put(neigh, new Node(neigh.val));
                    q.offer(neigh);
                }
                map.get(curr).neighbors.add(map.get(neigh));
            }
        }
        return map.get(node);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.addNeighbour(n2, n4);
        n2.addNeighbour(n1, n3);
        n3.addNeighbour(n2, n4);
        n4.addNeighbour(n1, n3);

        cloneGraph(n1);

    }
}
