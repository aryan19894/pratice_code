package pratice.gfg.companywise.amazon;

public class ConvertBinaryTreeToDoublyLinkedList {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

    static public class Solution {
        static Node head, tail, prev; //Head node of created doubly linked list

        static void convertToDLL(Node root) {
            if (root == null) return;

            convertToDLL(root.left);

            if (prev == null) head = root;
            else {
                root.left = prev;
                prev.right = root;
            }
            prev = root;

            convertToDLL(root.right);
        }

        static void printList() {
            System.out.println("Extracted Double Linked List is : ");
            while (head != null) {
                System.out.print(head.data + " ");
                head = head.right;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        Node root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);

        sol.convertToDLL(root);
        sol.printList();
    }
}
