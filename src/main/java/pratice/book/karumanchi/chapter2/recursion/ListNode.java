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

    public static ListNode copy(ListNode node) {
        if (node == null) return null;
        ListNode newNode = new ListNode(node.val);
        newNode.next = copy(node.next);
        return newNode;
    }
}
