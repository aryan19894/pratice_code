package revise._2024.striver.linkedlist.medium;

import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class RearrangeOddAndEvenPlaces {
    public static Node oddEvenList(Node head) {
        if (head == null || head.next == null || head.next.next == null)
            return head;

        Node odd = head;
        Node even = head.next;
        Node backup = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = backup;
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1, 2, 3, 4, 5, 6);

        Node result = oddEvenList(head);
        result.print();
    }
}
