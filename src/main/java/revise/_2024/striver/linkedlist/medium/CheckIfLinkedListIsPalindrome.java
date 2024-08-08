package revise._2024.striver.linkedlist.medium;

import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class CheckIfLinkedListIsPalindrome {
    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;
        if (head.data == head.next.data) return true;

        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node reverseNode = reverse(slow.next);

        Node first = head;
        Node second = reverseNode;
        while (second.next != null) {
            if (first.data != second.data) {
                reverse(reverseNode);
                return false;
            }
            first = first.next;
            second = second.next;
        }
        reverse(reverseNode);
        return true;
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) return head;

        Node newHead = reverse(head.next);
        Node front = head.next;
        head.next=null;
        front.next=head;
        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(1, 2, 3);

        System.out.println(isPalindrome(head));
    }
}
