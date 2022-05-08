package com.gfg.companywise.amazon;

import com.common.Out;

public class ReverseALinkedListInGroupsOfGivenSize {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static Node reverse(Node node, int k) {
        if (node == null || k == 1) return node;

        Node dummy = new Node(0);
        dummy.next = node;

        Node prev = dummy, curr = dummy, next = dummy;
        int len = 0;
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }

        while (len >= k) {
            curr = prev.next;
            next = curr.next;
            for (int i = 1; i < k; i++) {
                curr.next = next.next;
                next.next = prev.next;
                prev.next = next;
                next = curr.next;
            }
            prev = curr;
            len -= k;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        node.next.next.next.next.next = new Node(6);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(8);
        int k = 4;
        Out.print(reverse(node, k));
    }
}
