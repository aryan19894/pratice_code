package revise._2024.striver.linkedlist.medium;

import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class SortLinkedListOf_0s_1s_2s {
    public static Node sortList(Node head, int n) {
        if (head == null || head.next == null)
            return head;

        int[] freq = new int[n];
        Node temp = head;
        while (temp != null) {
            freq[temp.data]++;
            temp = temp.next;
        }

        Node curr = head;
        int digit = 0;
        while (curr != null) {
            if (freq[digit] == 0) digit++;
            curr.data = digit;

            freq[digit]--;
            curr = curr.next;
        }

        return head;
    }

    public static Node sortList2(Node head) {
        if (head == null || head.next == null)
            return head;

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);

        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;

        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = temp;
            } else if (temp.data == 1) {
                one.next = temp;
                one = temp;
            } else if (temp.data == 2) {
                two.next = temp;
                two = temp;
            }

            temp = temp.next;
        }

        two.next = null;
        one.next = twoHead.next;
        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;

        return zeroHead.next;
    }

    public static void main(String[] args) {
        Node head = new Node(1, 0, 2, 1, 0, 2, 1,3,4,3,3,2,3,4,1,2,1,2);

        sortList(head, 5).print();
        sortList2(head).print();
    }
}
