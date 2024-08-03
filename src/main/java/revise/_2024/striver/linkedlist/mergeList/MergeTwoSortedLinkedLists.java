package revise._2024.striver.linkedlist.mergeList;

import revise._2024.striver.linkedlist._nodes.SLL.generic.LinkedListNode;

public class MergeTwoSortedLinkedLists {

    public static LinkedListNode<Integer> sortTwoLists(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        if (first == null) return second;
        if (second == null) return first;

        LinkedListNode<Integer> result = new LinkedListNode<>(-1);
        LinkedListNode<Integer> ref = result;
        while (first != null && second != null) {
            if (first.data == second.data) {
                ref.next = new LinkedListNode<>(first.data);
                ref.next.next = new LinkedListNode<>(second.data);

                first = first.next;
                second = second.next;
                ref = ref.next.next;
            } else if (first.data < second.data) {
                ref.next = new LinkedListNode<>(first.data);
                first = first.next;
                ref = ref.next;
            } else {
                ref.next = new LinkedListNode<>(second.data);
                second = second.next;
                ref = ref.next;
            }
        }

        if (first != null) ref.next = first;
        if (second != null) ref.next = second;

        return result.next;
    }

    public static LinkedListNode<Integer> sortTwoLists2(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        if (first == null) return second;
        if (second == null) return first;

        LinkedListNode<Integer> dummy = new LinkedListNode<>(-1);
        LinkedListNode<Integer> ref = dummy;
        while (first != null && second != null) {
            LinkedListNode<Integer> next1 = first.next;
            LinkedListNode<Integer> next2 = second.next;
            if (first.data == second.data) {
                ref.next = first;
                first.next = second;
                second.next = null;

                first = next1;
                second = next2;
                ref = ref.next.next;
            } else if (first.data < second.data) {
                ref.next = first;
                first.next = null;

                first = next1;
                ref = ref.next;
            } else {
                ref.next = second;
                second.next = null;

                second = next2;
                ref = ref.next;
            }
        }

        if (first != null) ref.next = first;
        if (second != null) ref.next = second;

        return dummy.next;
    }

    public static LinkedListNode<Integer> sortTwoLists3(LinkedListNode<Integer> first, LinkedListNode<Integer> second) {
        if (first == null) return second;
        if (second == null) return first;

        LinkedListNode<Integer> dummy = new LinkedListNode<>(-1);
        LinkedListNode<Integer> temp = dummy;
        while (first != null && second != null) {
            if (first.data < second.data) {
                temp.next = first;
                temp = first;

                first = first.next;
            } else {
                temp.next = second;
                temp = second;

                second = second.next;
            }
        }

        if (first != null) temp.next = first;
        if (second != null) temp.next = second;

        return dummy.next;
    }

    public static void main(String[] args) {
        LinkedListNode<Integer> head1 = new
                LinkedListNode<Integer>(1, 5, 9, 11);
        LinkedListNode<Integer> head2 = new
                LinkedListNode<Integer>(2, 2, 3, 5, 8);

        LinkedListNode<Integer> result = sortTwoLists3(head1, head2);
        if (result != null)
            result.print();
        else
            System.out.println("null");
    }
}
