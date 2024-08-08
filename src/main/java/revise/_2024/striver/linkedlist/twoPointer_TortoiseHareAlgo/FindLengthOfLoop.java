package revise._2024.striver.linkedlist.twoPointer_TortoiseHareAlgo;

import common.Out;
import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class FindLengthOfLoop {
    public static int lengthOfLoop(Node head) {
        if (head == null || head.next == null) return 0;
        if (head.next == head) return 1;

        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow.equals(fast)) return findLength(slow, fast);
        }

        return 0;
    }

    private static int findLength(Node slow, Node fast) {
        int len = 1;
        fast = fast.next;
        while (slow != fast) {
            len++;
            fast = fast.next;
        }
        return len;
    }

    public static void main(String[] args) {
        Node head = new Node(1,2,3);
//        head.makeCyclic(0);
        Out.print(lengthOfLoop(head));
    }
}
