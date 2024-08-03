package revise._2024.striver.linkedlist._nodes.SLL;

public class LinkedListNode {
    public int data;
    public LinkedListNode next;

    public LinkedListNode(int data) {
        this.data = data;
    }

    public LinkedListNode(int data, LinkedListNode next) {
        this.data = data;
        this.next = next;
    }

    public LinkedListNode(int... ele) {
        if(ele.length==0) return;
        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode root = dummy;
        for (int a : ele) {
            root.next = new LinkedListNode(a);
            root = root.next;
        }
        dummy = dummy.next;
        this.data = dummy.data;
        this.next = dummy.next;
    }

    public static void makeIntersect(LinkedListNode l1, LinkedListNode l2, int... ele) {
        LinkedListNode in = new LinkedListNode(ele);

        while (l1.next != null) l1 = l1.next;
        l1.next = in;
        while (l2.next != null) l2 = l2.next;
        l2.next = in;
    }

    public void print() {
        LinkedListNode node = this;
        if (node == null)
            System.out.println("null");
        System.out.println();
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public void makeCyclic(int idx) {
        LinkedListNode dummy = this;
        while (idx-- > 0)
            dummy = dummy.next;

        LinkedListNode cy = dummy;
        while (dummy.next != null) dummy = dummy.next;
        dummy.next = cy;
    }
}
