package revise._2024.striver.linkedlist.medium;

import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class DeleteKthNodeFromEnd {
    public static Node removeKthNode(Node head, int K) {
        if (head == null) return null;
        if (K <= 0) return head;
        if (head.next == null) return K == 1 ? null : head;

        Node slow = head;
        Node fast = head;
        while (K-- > 0) {
            if (fast == null) return head;
            fast = fast.next;
        }

        if (fast == null) return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1, 2, 3, 4, 5);

        Node res = removeKthNode(head, -10);
        if (res != null)
            res.print();
        else
            System.out.println("null");
    }
}
