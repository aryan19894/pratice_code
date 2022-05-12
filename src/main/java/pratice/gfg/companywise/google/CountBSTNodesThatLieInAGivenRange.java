package pratice.gfg.companywise.google;

import pratice.common.Out;

public class CountBSTNodesThatLieInAGivenRange {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    static public class Solution {
        int getCount(Node root, int l, int h) {
            if (root == null) return 0;

            int count = getCount(root.left, l, h) + getCount(root.right, l, h);
            if (root.data >= l && root.data <= h)
                return count + 1;
            return count;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(3);
//		root.left.right = new Node(60);
        root.right = new Node(6);
        //root.right.left = new Node(40);
        root.right.right = new Node(7);
//
        int l = 2;
        int h = 8;
        Out.print(sol.getCount(root, l, h));
    }
}
