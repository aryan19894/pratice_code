package com.gfg.companywise.facebook;

public class ConvertTernaryExpressionToABinaryTree {
    static class Node {
        char data;
        Node left, right;

        public Node(char item) {
            data = item;
            left = null;
            right = null;
        }
    }

    static public class Solution {
        Node convertExpression(char[] expression, int i) {
            if (i >= expression.length) return null;
            Node root = new Node(expression[i++]);

            if (i < expression.length && expression[i] == '?')
                root.left = convertExpression(expression, i + 1);
            else if (i < expression.length)
                root.right = convertExpression(expression, i + 1);

            return root;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        String exp = "a?b?c:d:e";
        int i = 0;
        printTree(sol.convertExpression(exp.toCharArray(), i));
    }

    public static void printTree(Node root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        printTree(root.left);
        printTree(root.right);
    }
}
