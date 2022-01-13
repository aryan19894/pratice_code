package com.striver.DSAExperience.Day5LinkedList;

public class LinkedList {
    ListNode head;

    public LinkedList() {
    }

    public LinkedList(int[] ele) {
        this.addElement(ele);
    }

    // prints content of double linked list
    void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

    public ListNode addElement(int[] ele) {
        head = new ListNode(ele[0]);
        ListNode ref = head;
        for (int i = 1; i < ele.length; i++) {
            ref.next = new ListNode(ele[i]);
            ref = ref.next;
        }
        return head;
    }
}
