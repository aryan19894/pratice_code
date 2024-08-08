package revise._2024.striver.linkedlist.basic.SLL;

import common.Out;
import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class SearchInLinkedList {
    static boolean searchKey(int n, Node head, int key) {
        while (head != null) {
            if (head.data == key) return true;
            head = head.next;
        }
        return false;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 3, 4, 5};
        Node root = ArrayToLinkedList.constructLL(arr);
        Out.print(searchKey(n, root, 6));
    }
}
