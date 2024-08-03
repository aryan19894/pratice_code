package revise._2024.striver.linkedlist.medium;

import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class RotateLinkedList {
    public static Node rotate(Node head, int k) {
        if (head == null) return null;
        int size = size(head);
        k %= size;
        if (k <= 0) return head;

        int it = size - k - 1;
        Node temp = head;
        while (--it >= 0) temp = temp.next;

        Node newHead = temp.next;
        temp.next = null;

        Node swap = newHead;
        while (swap.next != null)
            swap = swap.next;

        swap.next = head;

        return newHead;
    }

    public static Node rotate2(Node head, int k) {
        if (head == null) return null;
        int size = size(head);
        k %= size;
        if (k <= 0) return head;

        Node tail = head;
        while (tail.next != null) tail = tail.next;
        tail.next = head;

        int it = size - k - 1;
        Node temp = head;
        while (--it >= 0) temp = temp.next;
        head = temp.next;
        temp.next = null;

        return head;
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
        Node head = new Node(1, 2, 3, 4, 5, 6);
        rotate2(head, 2).print();
    }
}
