package revise._2024.striver.linkedlist.basic.SLL;

import common.Out;
import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class ArrayToLinkedList {

    static Node constructLL(int arr[]) {
        int n = arr.length;
        if (n == 0) return null;

        Node root = new Node(arr[0]);
        Node ref = root;

        for (int i = 1; i < arr.length; i++) {
            ref.next = new Node(arr[i]);
            ref = ref.next;
        }
        return root;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 3, 4, 5};

        Out.print(constructLL(arr));
    }
}
