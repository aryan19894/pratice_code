package revise._2024.striver.linkedlist.basic.DLL;

import common.Out;
import revise._2024.striver.linkedlist._nodes.DLL.Node;

public class ReverseADoublyLinkedList {
    public static Node reverseDLL(Node head) {
        if (head == null || head.next == null)
            return head;

        Node prev = null;
        Node curr = head;
        while (curr != null) {
            prev = curr.prev;
            curr.prev = curr.next;
            curr.next = prev;

            curr = curr.prev;
        }
        return prev.prev;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] arr = {3, 4, 5};
        Node head = IntroToDoublyLinkedList.constructDLL(arr);
        Out.print(reverseDLL(head));
    }
}
