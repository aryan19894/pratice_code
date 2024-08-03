package revise._2024.striver.linkedlist.twoPointer_TortoiseHareAlgo;

import common.Out;
import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class CycleDetectionInASLL {
    public static boolean detectCycle(Node head) {
        if (head == null || head.next == null) return false;
        if (head.next == head) return true;

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1, 2, 3, 4, 5, 6, 7, 8, 9);
        head.makeCyclic(2);
        Out.print(detectCycle(head));
    }
}
