package revise._2024.striver.linkedlist.medium;

import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class AddOneToANumberRepresentedAsLinkedList {
    public static Node addOne(Node head) {
        if (head == null) return new Node(1);

        Node reverse = reverse(head);
        Node sum = sum(reverse, 1);
        return reverse(sum);
    }

    private static Node sum(Node num1, int n) {
        int carry = n;
        Node res = new Node(-1);
        Node ref = res;
        while (num1 != null) {
            int sum = carry + num1.data;

            ref.next = new Node(sum % 10);
            carry = sum / 10;

            num1 = num1.next;
            ref = ref.next;
        }
        if (carry > 0)
            ref.next = new Node(carry);

        return res.next;
    }

    private static Node reverse(Node head) {
        if (head == null || head.next == null) return head;

        Node newHead = reverse(head.next);
        Node front = head.next;
        head.next = null;
        front.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        Node head = new Node(9,9,9);

        System.out.println(addOne(head));
    }
}
