package com.striver.DSAExperience.Day5LinkedList;

public class LinkedList {
    public ListNode head;
    private ListNode tail;
    public int size = 0;

    public LinkedList() {
    }

    public LinkedList(int[] ele) {
        this.addElement(ele);
    }

    public ListNode addElement(int[] ele) {
        head = new ListNode(ele[0]);
        ListNode ref = head;
        for (int i = 1; i < ele.length; i++) {
            ref.next = new ListNode(ele[i]);
            tail = ref = ref.next;
        }
        this.size += ele.length;
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
        this.size++;
    }

    public void addLast(LinkedList newList) {
        if (head == null)
            head = newList.head;
        else
            tail.next = newList.head;

        tail = newList.tail;
        this.size++;
    }

    public void appendElement(int[] ele) {
        for (int e : ele) {
            tail.next = new ListNode(e);
            tail = tail.next;
        }
        this.size += ele.length;
    }

    public void makeCycle(int index) {
        ListNode dummy = head;
        for (int i = 0; i < index; i++)
            dummy = dummy.next;
        tail.next = dummy;
    }
}
