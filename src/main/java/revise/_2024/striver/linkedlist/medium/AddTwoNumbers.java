package revise._2024.striver.linkedlist.medium;

import revise._2024.striver.linkedlist._nodes.SLL.LinkedListNode;

public class AddTwoNumbers {
    static LinkedListNode addTwoNumbers(LinkedListNode head1, LinkedListNode head2) {
        LinkedListNode result = new LinkedListNode(-1);
        int carry = 0;
        LinkedListNode ref = result;

        while (head1 != null || head2 != null || carry == 1) {
            int sum = carry;
            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }
            if (head2 != null) {
                sum += head2.data;
                head2 = head2.next;
            }

            ref.next = new LinkedListNode(sum % 10);
            ref = ref.next;
            carry = sum / 10;
        }
        return result.next;
    }

    public static void main(String[] args) {
        LinkedListNode l1 = new LinkedListNode(1, 2, 3, 9, 9, 9, 1);
        LinkedListNode l2 = new LinkedListNode(4, 5, 9);

        addTwoNumbers(l1,l2).print();
    }
}
