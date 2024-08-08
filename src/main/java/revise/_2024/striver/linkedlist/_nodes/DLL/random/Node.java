package revise._2024.striver.linkedlist._nodes.DLL.random;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Node {
    public int data;
    public Node next;
    public Node random;

    public Node(int data) {
        this.data = data;
    }

    public Node(int... ele) {
        if (ele.length == 0) return;
        Node dummy = new Node(-1);
        Node root = dummy;
        for (int a : ele) {
            root.next = new Node(a);
            if (root.data != -1)
                root.next.random = root;
            root = root.next;
        }
        dummy = dummy.next;
        this.data = dummy.data;
        this.next = dummy.next;
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

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
