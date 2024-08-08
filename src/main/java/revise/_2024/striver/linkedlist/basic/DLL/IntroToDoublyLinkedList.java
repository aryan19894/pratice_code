package revise._2024.striver.linkedlist.basic.DLL;

import common.Out;
import revise._2024.striver.linkedlist._nodes.DLL.Node;

public class IntroToDoublyLinkedList {
    static Node constructDLL(int arr[]) {
        int n = arr.length;
        if (n == 0) return null;

        Node head = new Node(arr[0]);
        Node ref = head;
        for (int i = 1; i < n; i++) {
            ref.next = new Node(arr[i]);
            ref.next.prev = ref;
            ref = ref.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 3, 4, 5};

        Out.print(constructDLL(arr));
    }
}
