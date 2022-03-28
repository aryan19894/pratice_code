package com.gfg.companywise.amazon;

import com.common.Out;

public class AddTwoNumbersByLinkedLists {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    static Node addTwoLists(Node first, Node second) {
        //edge cases
        if (first == null && second == null) return null;
        if (first == null) return second;
        if (second == null) return first;

        first = reverse(first);
        second = reverse(second);
        Node dummy = new Node(0);
        Node temp = dummy;

        int carry = 0, sum = 0;
        while (first != null || second != null) {
            sum = data(first) + data(second) + carry;
            carry = sum / 10;
            sum %= 10;
            temp.next = new Node(sum);
            temp = temp.next;
            if (first != null)
                first = first.next;
            if (second != null)
                second = second.next;
        }
        if (carry != 0)
            temp.next = new Node(carry);

        return reverse(dummy.next);
    }

    private static int data(Node node) {
        if (node == null) return 0;
        return node.data;
    }

    static Node reverse(Node node) {
        Node prev = null, next = null, curr = node;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        Node first = new Node(4);
        first.next = new Node(5);

        Node second = new Node(3);
        second.next = new Node(4);
        second.next.next = new Node(5);

        Out.print(addTwoLists(first, second));
    }
}
