package revise._2024.striver.linkedlist.twoPointer_TortoiseHareAlgo;

import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class MiddleOfLinkedList {
    public static Node findMiddle(Node head) {
        if (head == null || head.next == null) return head;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node head1 = new Node(1, 2, 3, 4, 5,6);

        System.out.println(findMiddle(head1));
    }
}
