package revise._2024.striver.linkedlist.medium;

import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class ReverseLinkedList {
    public static Node reverseLinkedList(Node head) {
        if (head == null || head.next == null) return head;

        Node prev = null;
        Node temp = head;
        while (temp != null) {
            Node front = temp.next;
            temp.next = prev;

            prev = temp;
            temp = front;
        }
        return prev;
    }

    public static Node reverseLinkedListRecursive(Node head) {
        return reverse(null, head);
    }

    private static Node reverse(Node prev, Node temp) {
        if (temp == null) return prev;

        Node front = temp.next;
        temp.next = prev;
        prev=temp;

        return reverse(prev, front);
    }

    public static void main(String[] args) {
        Node head = new Node();

//        reverseLinkedList(head).print();
        reverseLinkedListRecursive(head).print();
    }
}
