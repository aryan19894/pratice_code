package revise._2024.striver.linkedlist.twoPointer_TortoiseHareAlgo;

import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class LinkedListCycle_II {
    public static int firstNode(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) return findStartPoint(head, fast).data;
        }
        return -1;
    }

    private static Node findStartPoint(Node slow, Node fast) {
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1, 2, 3, 15, 4, 13, 6, 7, 8, 9);
        head.makeCyclic(3);
        int ans = firstNode(head);
        System.out.println(ans);
    }
}
