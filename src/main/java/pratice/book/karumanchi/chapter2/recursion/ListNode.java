package pratice.book.karumanchi.chapter2.recursion;

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

    public static void print(ListNode node) {
        if (node == null)
            System.out.println("null");
        System.out.println();
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode get(int... data) {
        ListNode head = new ListNode(-1);
        ListNode ref = head;
        for (int d : data) {
            ref.next = new ListNode(d);
            ref = ref.next;
        }
        return head.next;
    }
}
