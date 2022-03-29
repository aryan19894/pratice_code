package com.gfg.companywise.amazon;

import com.common.Out;
import com.common.converter.Str;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class VerticalTraversalOfBinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }

        public static Node toTree(String input) {
            return toTree(Str.toArray(input));
        }

        public static Node toTree(Integer[] ip) {
            if (ip.length == 0 || ip[0] == -1)
                return null;

            Node root = new Node(ip[0]);
            Queue<Node> q = new LinkedList<>();
            q.add(root);

            for (int i = 1; i < ip.length && !q.isEmpty(); i++) {
                Node currNode = q.poll();
                if (ip[i] != null) {
                    currNode.left = new Node(ip[i]);
                    q.add(currNode.left);
                }
                ++i;
                if (i < ip.length && ip[i] != null) {
                    currNode.right = new Node(ip[i]);
                    q.add(currNode.right);
                }
            }
            return root;
        }

    }

//    static class Tuple {
//        Node node;
//        int hd;
//
//        public Tuple(Node node, int hd) {
//            this.node = node;
//            this.hd = hd;
//        }
//    }

    static class Tuple {
        Node node;
        int hd;
        int row, col;

        public Tuple(Node node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }

        public Tuple(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    static ArrayList<Integer> verticalOrder1(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeMap<Integer, TreeMap<Integer, List<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        if (root == null) return result;
        q.offer(new Tuple(root, 0, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Tuple ref = q.poll();
                Node node = ref.node;
                int x = ref.row;
                int y = ref.col;

                map.putIfAbsent(x, new TreeMap<>());
                map.get(x).putIfAbsent(y, new ArrayList<>());
                map.get(x).get(y).add(node.data);

                if (node.left != null)
                    q.offer(new Tuple(node.left, x - 1, y + 1));
                if (node.right != null)
                    q.offer(new Tuple(node.right, x + 1, y + 1));
            }
        }

        for (TreeMap<Integer, List<Integer>> m : map.values()) {
            for (List<Integer> l : m.values()) {
                result.addAll(l);
            }
        }

        return result;
    }

    static ArrayList<Integer> verticalOrder2(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();

        if (root == null) return result;
        q.offer(new Tuple(root, 0));

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Tuple ref = q.poll();
                Node node = ref.node;
                int x = ref.hd;

                map.putIfAbsent(x, new ArrayList<>());
                map.get(x).add(node.data);

                if (node.left != null)
                    q.offer(new Tuple(node.left, x - 1));
                if (node.right != null)
                    q.offer(new Tuple(node.right, x + 1));
            }
        }
        for (List<Integer> l : map.values())
            result.addAll(l);

        return result;
    }

    public static void main(String[] args) throws IOException {
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//
//        root.right = new Node(3);
//        root.right.left = new Node(6);
//        root.right.left.right = new Node(8);
//
//        root.right.right = new Node(7);
//        root.right.right.right = new Node(9);

        Node root = Node.toTree(readFile());
        Out.print(verticalOrder1(root));
        Out.print(verticalOrder2(root));
    }

    private static String readFile() throws IOException {
        File file = new File(
                "E:\\code\\DSA\\Platform\\testcase\\fileInput.txt");

        BufferedReader br
                = new BufferedReader(new FileReader(file));

        String res = "", line = "";
        while ((line = br.readLine()) != null)
            res += line;
        return res;
    }
}
