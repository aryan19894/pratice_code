package com.gfg.companywise.amazon;

public class RemoveLoopInLinkedList {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void removeLoop(Node head) {
        if (head == null || head.next == null)
            return;

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                break;
        }
        if (slow == fast) {
            slow = head;
            if (slow != fast) {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            } else {
                //meet slow fast at 1st position
                while (slow != fast.next)
                    fast = fast.next;
            }
            fast.next = null;
        }
    }

    public static void main(String[] args) {
//        Node head = new Node(7);
//        head.next = new Node(58);
//        head.next.next = new Node(36);
//        head.next.next.next = new Node(34);
//        head.next.next.next.next = new Node(16);
//        head.next.next.next.next.next = head;

        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(4);
        head.next.next.next = head.next;
//        head.next.next.next.next = new Node(16);
//        head.next.next.next.next.next = head;

        removeLoop(head);
    }
}
