package com.leetcode.blind75.T4Graph;

import java.util.*;

public class CloneGraph_medium_133 {
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
    }

    static class Solution {
        public Node cloneGraph(Node node) {
            if (node == null) return null;
            Node copy = new Node(node.val);
            Node[] visited = new Node[101];
            Arrays.fill(visited, null);

            clone(node, copy, visited);
            return copy;
        }

        private void clone(Node node, Node copy, Node[] visited) {
            visited[copy.val] = copy;
            for (Node n : node.neighbors) {
                if (visited[n.val] == null) {
                    Node newNode = new Node(n.val);
                    copy.neighbors.add(newNode);
                    clone(n, newNode, visited);
                } else
                    copy.neighbors.add(visited[n.val]);
            }
        }

        public Node cloneGraph2(Node node) {
            if (node == null) return null;
            HashMap<Node, Node> visited = new HashMap<>();
            LinkedList<Node> q = new LinkedList<>();
            q.offer(node);
            visited.put(node, new Node(node.val));
            while (!q.isEmpty()) {
                Node curr = q.remove();
                for (Node neighbor : curr.neighbors) {
                    if (!visited.containsKey(neighbor)) {
                        q.offer(neighbor);
                        Node newNode = new Node(neighbor.val);
                        visited.put(neighbor, newNode);
                    }
                    visited.get(curr).neighbors.add(visited.get(neighbor));
                }
            }
            return visited.get(node);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node3);
        node4.neighbors.add(node1);

        sol.cloneGraph(node1);
        sol.cloneGraph2(node1);
    }
}
