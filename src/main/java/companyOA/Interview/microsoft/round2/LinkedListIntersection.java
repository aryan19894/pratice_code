package companyOA.Interview.microsoft.round2;

public class LinkedListIntersection {
    static Node findIntersection(Node head1, Node head2) {
        Node p1 = head1;
        Node p2 = head2;

        if (p1 == null || p2 == null)
            return null;

        while (p1 != p2) {

            p1 = p1.next;
            p2 = p2.next;

            if (p1 == p2)
                return p1;
            if (p1 == null)
                p1 = head2;
            if (p2 == null)
                p2 = head1;
        }

        return p1;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

    static class Node {
        public Node next;
    }

}
