package revise._2024.striver.linkedlist.medium;

import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class ReverseListInKGroups {
    public static Node kReverse(Node head, int k) {
        if (head == null) return null;
        int size = size(head);
        if (size < k) return head;

        Node prev = null;
        Node next = null;
        Node temp = head;
        for (int count = 0; temp != null && count < k; count++) {
            next = temp.next;
            temp.next = prev;

            prev = temp;
            temp = next;
        }
        if (next != null)
            head.next = kReverse(next, k);
        return prev;
    }

    public static int size(Node head) {
        int len = 0;
        Node ref = head;
        while (ref != null) {
            len++;
            ref = ref.next;
        }
        return len;
    }

    public static void main(String[] args) {
        Node head = new Node(1, 2, 3, 4, 2, 3, 4, 6);
        kReverse(head, 3).print();
    }
}
