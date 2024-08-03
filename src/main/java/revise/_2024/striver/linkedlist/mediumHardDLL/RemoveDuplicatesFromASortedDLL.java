package revise._2024.striver.linkedlist.mediumHardDLL;

import common.Out;
import revise._2024.striver.linkedlist._nodes.DLL.Node;

public class RemoveDuplicatesFromASortedDLL {
    public static Node uniqueSortedList(Node head) {
        if (head == null || head.next == null) return head;

        Node temp = head;
        while (temp.next != null) {
            if (temp.data == temp.next.data) {
                temp.next = temp.next.next;
                if (temp.next != null)
                    temp.next.prev = temp;
            } else temp = temp.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(1, 2,3);
        Out.print(uniqueSortedList(head));
    }
}
