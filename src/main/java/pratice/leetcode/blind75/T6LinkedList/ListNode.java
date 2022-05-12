package pratice.leetcode.blind75.T6LinkedList;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static ListNode toNode(int[] arr) {
        ListNode dummy = new ListNode();
        ListNode root = dummy;
        for (int a : arr) {
            root.next = new ListNode(a);
            root = root.next;
        }
        return dummy.next;
    }

    public static ListNode[] toNode(int[][] arr) {
        int n = arr.length;
        ListNode[] root = new ListNode[n];
        int i = 0;
        for (int[] a : arr)
            root[i++] = toNode(a);
        return root;
    }

    public static void print(ListNode node) {
        if (node == null)
            System.out.println("null");
        System.out.println();
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
