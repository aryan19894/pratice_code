package revise._2024.striver.linkedlist._nodes.SLL;

public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int... ele) {
        if(ele.length==0) return;
        Node dummy = new Node(-1);
        Node root = dummy;
        for (int a : ele) {
            root.next = new Node(a);
            root = root.next;
        }
        dummy = dummy.next;
        this.data = dummy.data;
        this.next = dummy.next;
    }

    public static void makeIntersect(Node l1, Node l2, int... ele) {
        Node in = new Node(ele);

        while (l1.next != null) l1 = l1.next;
        l1.next = in;
        while (l2.next != null) l2 = l2.next;
        l2.next = in;
    }

    public void print() {
        Node node = this;
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
        Node dummy = this;
        while (idx-- > 0)
            dummy = dummy.next;

        Node cy = dummy;
        while (dummy.next != null) dummy = dummy.next;
        dummy.next = cy;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
