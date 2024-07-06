package revise.striver.DSAExperience.T3LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int... ele) {
        ListNode dummy = new ListNode(-1);
        ListNode root = dummy;
        for (int a : ele) {
            root.next = new ListNode(a);
            root = root.next;
        }
        dummy = dummy.next;
        this.val = dummy.val;
        this.next = dummy.next;
    }

    public static void makeIntersect(ListNode l1, ListNode l2, int... ele) {
        ListNode in = new ListNode(ele);

        while (l1.next != null) l1 = l1.next;
        l1.next = in;
        while (l2.next != null) l2 = l2.next;
        l2.next = in;
    }

    public void print() {
        ListNode node = this;
        if (node == null)
            System.out.println("null");
        System.out.println();
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void makeCyclic(int idx) {
        ListNode dummy = this;
        while (idx-- > 0)
            dummy = dummy.next;

        ListNode cy = dummy;
        while (dummy.next != null) dummy = dummy.next;
        dummy.next = cy;
    }
}
