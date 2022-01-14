package com.striver.DSAExperience.Day5LinkedList;

public class LinkedList {
    public ListNode head;
    private ListNode tail;

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
            tail = ref = ref.next;
        }
        return head;
    }

    public void addLast(ListNode newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public void addLast(LinkedList newList) {
        if (head == null)
            head = newList.head;
        else
            tail.next = newList.head;

        tail = newList.tail;
    }

    public void appendElement(int[] ele) {
        for (int e : ele) {
            tail.next = new ListNode(e);
            tail = tail.next;
        }
    }

    public void makeCycle(int index) {
        ListNode dummy = head;
        for (int i = 0; i <= index; i++)
            dummy = dummy.next;
        tail.next = dummy;
    }
}
