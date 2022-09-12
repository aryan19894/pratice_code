package other.ayush.visa.hackerrank;

import java.io.BufferedWriter;
import java.io.IOException;

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
    public SinglyLinkedListNode head;
    public SinglyLinkedListNode tail;

    public SinglyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void insertNode(int nodeData) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

        if (this.head == null) {
            this.head = node;
        } else {
            this.tail.next = node;
        }

        this.tail = node;
    }
}

class SinglyLinkedListPrintHelper {
    public static void printList(SinglyLinkedListNode node, String sep, BufferedWriter bufferedWriter) throws IOException {
        while (node != null) {
            bufferedWriter.write(String.valueOf(node.data));

            node = node.next;

            if (node != null) {
                bufferedWriter.write(sep);
            }
        }
    }
}

public class ReversingLinkedList {
    public static SinglyLinkedListNode reversingLinkedList(SinglyLinkedListNode head) {
        // finding length of linked list
        int len = 0;
        SinglyLinkedListNode ref = head;
        while (ref != null) {
            len++;
            ref = ref.next;
        }

        int left = 0, right = len - 1;
        while (left < right) {
            head = reverseBetween(head, left + 1, right + 1);
            right--;
            left++;
        }

        return head;
    }

    public static SinglyLinkedListNode reverseBetween(SinglyLinkedListNode head, int left, int right) {
        if (left == right)
            return head;

        SinglyLinkedListNode revs = null, revs_prev = null;
        SinglyLinkedListNode revend = null, revend_next = null;

        // Find values of above pointers.
        int i = 1;
        SinglyLinkedListNode curr = head;
        while (curr != null && i <= right) {
            if (i < left)
                revs_prev = curr;
            if (i == left)
                revs = curr;
            if (i == right) {
                revend = curr;
                revend_next = curr.next;
            }
            curr = curr.next;
            i++;
        }
        revend.next = null;
        revend = reverse(revs);
        if (revs_prev != null)
            revs_prev.next = revend;
        else
            head = revend;
        revs.next = revend_next;
        return head;
    }

    static SinglyLinkedListNode reverse(SinglyLinkedListNode node) {
        SinglyLinkedListNode prev = null;
        SinglyLinkedListNode current = node;

        while (current != null) {
            SinglyLinkedListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public static void main(String[] args) {
        SinglyLinkedList head = new SinglyLinkedList();

        head.insertNode(1);
        head.insertNode(5);
        head.insertNode(2);
        head.insertNode(7);
        head.insertNode(8);
        head.insertNode(3);

        SinglyLinkedListNode result = reversingLinkedList(head.head);

    }

}
