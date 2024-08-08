package revise._2024.striver.linkedlist._nodes.DLL.child;

public class Node {
    public int data;
    public Node next;
    public Node child;

    Node() {
        this.data = 0;
        this.next = null;
        this.child = null;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
        this.child = null;
    }

    Node(int data, Node next, Node child) {
        this.data = data;
        this.next = next;
        this.child = child;
    }

    public Node(int... ele) {
        if (ele.length == 0) return;
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

    public Node(int[]... sets) {
        Node dummy = new Node(-1);
        Node temp = dummy;
        for (int[] list : sets) {
            temp.next = new Node(list[0]);
            Node backup = temp.next;
            Node ref = temp.next;
            for (int i = 1; i < list.length; i++) {
                ref.child = new Node(list[i]);
                ref = ref.child;
            }
            temp = backup;
        }
        dummy = dummy.next;
        this.data = dummy.data;
        this.next = dummy.next;
        this.child = dummy.child;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                ", child=" + child +
                '}';
    }

    public void print() {
        Node node = this;
        if (node == null)
            System.out.println("null");
        System.out.println();
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.child;
        }
        System.out.println();
    }
}
