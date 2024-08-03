package revise._2024.striver.linkedlist.medium;

import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class IntersectionOfTwoLinkedLists {
    public static int findIntersection(Node head1, Node head2) {
        if (head1 == null || head2 == null) return -1;
        int diff = getLengthDiff(head1, head2);
        if (diff < 0)
            while (diff++ != 0) head2 = head2.next;
        else
            while (diff-- != 0) head1 = head1.next;

        while (head1 != null) {
            if (head1.equals(head2)) return head1.data;
            head1 = head1.next;
            head2 = head2.next;
        }
        return -1;
    }

    private static int getLengthDiff(Node head1, Node head2) {
        int len1 = 0, len2 = 0;
        while (head1 != null || head2 != null) {
            if (head1 != null) {
                len1++;
                head1 = head1.next;
            }
            if (head2 != null) {
                len2++;
                head2 = head2.next;
            }
        }
        return len1 - len2;
    }

    public static void main(String[] args) {
        Node head1 = new Node(3, 1, 1, 1);
        Node head2 = new Node(4, 5);

        Node.makeIntersect(head1, head2, 14, 6, 2);

        System.out.println(findIntersection(head1, head2));
    }
}
