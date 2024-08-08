package revise._2024.striver.linkedlist.twoPointer_TortoiseHareAlgo;

import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class DeleteMiddleNode {
    public static Node deleteMiddle(Node head) {
        if (head == null || head.next == null) return null;

        Node slow = head;
        Node fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow.next != null)
            slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1, 2, 3, 4, 5,6);
        Node res = deleteMiddle(head);
        if (res != null)
            res.print();
        else System.out.println("null");
    }
}
