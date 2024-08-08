package revise._2024.striver.linkedlist.mergeList;

import revise._2024.striver.linkedlist._nodes.DLL.child.Node;

public class FlattenALinkedList {

    public static Node flattenLinkedList(Node head) {
        if (head == null || head.next == null) return head;

        Node mergedHead = flattenLinkedList(head.next);
        return mergeTwoSortedList(head, mergedHead);
    }

    private static Node mergeTwoSortedList(Node t1, Node t2) {
        if (t1 == null) return t2;
        if (t2 == null) return t1;

        Node dummy = new Node(-1);
        Node res = dummy;

        while (t1 != null && t2 != null) {
            if (t1.data < t2.data) {
                res.child = t1;
                res = t1;

                t1 = t1.child;
            } else {
                res.child = t2;
                res = t2;
                t2 = t2.child;
            }
            res.next = null;
        }

        if (t1 != null) res.child = t1;
        if (t2 != null) res.child = t2;

        if (dummy.child != null) dummy.child.next = null;

        return dummy.child;
    }

    public static void main(String[] args) {
        Node head = new Node(
                new int[]{12, 19, 20, 29},
                new int[]{7, 26, 31, 33},
                new int[]{15},
                new int[]{9, 16, 18},
                new int[]{5, 8, 21, 42},
                new int[]{50},
                new int[]{13, 17, 23, 37}
        );

        Node result = flattenLinkedList(head);
        if (result != null)
            result.print();
        else
            System.out.println("null");
    }
}
