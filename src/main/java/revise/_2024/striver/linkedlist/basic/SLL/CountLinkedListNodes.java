package revise._2024.striver.linkedlist.basic.SLL;

import common.Out;
import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class CountLinkedListNodes {
    static public int getCount(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 3, 4, 5};
        Node root = ArrayToLinkedList.constructLL(arr);
        Out.print(getCount(root));
    }
}
