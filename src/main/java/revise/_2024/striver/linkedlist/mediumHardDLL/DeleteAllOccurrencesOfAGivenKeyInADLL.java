package revise._2024.striver.linkedlist.mediumHardDLL;

import common.Out;
import revise._2024.striver.linkedlist._nodes.DLL.Node;

public class DeleteAllOccurrencesOfAGivenKeyInADLL {
    public static Node deleteAllOccurrences(Node head, int k) {
        if (head == null) return null;
        if (head.next == null && head.data == k) return null;

        while (head.data == k) {
            head = head.next;
            if (head == null) return null;
            head.prev = null;
        }

        Node temp = head;
        while (temp != null) {
            if (temp.data == k) {
                if (temp.next != null) temp.next.prev = temp.prev;
                if (temp.prev != null) temp.prev.next = temp.next;
            }
            temp = temp.next;
        }

        return head;
    }

    public static Node deleteAllOccurrences2(Node head, int k) {
        if (head == null) return null;
        if (head.next == null && head.data == k) return null;

        while (head.data == k) {
            head = head.next;
            if (head == null) return null;
            head.prev = null;
        }

        Node slow = head;
        Node fast = head;
        while (fast != null) {
            while (fast.data == k) {
                fast = fast.next;
                if (fast == null) {
                    slow.prev.next = null;
                    return head;
                }
            }
            if (slow != fast) {
                slow.prev.next = fast;
                fast.prev = slow.prev;

                slow = fast;
            }

            slow = slow.next;
            fast = fast.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(10, 10, 10, 4, 10, 10, 10, 10, 10, 10, 6);
        Out.print(deleteAllOccurrences2(head, 10));
    }
}
