package revise._2024.striver.linkedlist.mergeList;

import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class SortLinkedList {
    public static Node sortLL(Node head) {
        if (head == null || head.next == null) return head;

        Node middle = findMiddle(head);
        Node right = middle.next;
        middle.next = null;
        Node left = head;

        left = sortLL(left);
        right = sortLL(right);

        return mergeTwoSortedList(left, right);
    }

    private static Node findMiddle(Node head) {
        if (head == null || head.next == null) return head;

        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static Node mergeTwoSortedList(Node left, Node right) {
        if (left == null) return right;
        if (right == null) return left;

        Node dummy = new Node(-1);
        Node temp = dummy;

        while (left != null && right != null) {
            if (left.data < right.data) {
                temp.next = left;
                temp = left;
                left = left.next;
            } else {
                temp.next = right;
                temp = right;
                right = right.next;
            }
        }

        if (left != null) temp.next = left;
        if (right != null) temp.next = right;

        return dummy.next;
    }

    public static void main(String[] args) {
        Node head = new Node(3, 1, 2, 1,5,2);

        Node result = sortLL(head);
        if (result != null)
            result.print();
        else
            System.out.println("null");
    }
}
