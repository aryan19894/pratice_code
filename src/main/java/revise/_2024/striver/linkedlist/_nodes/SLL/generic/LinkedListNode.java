package revise._2024.striver.linkedlist._nodes.SLL.generic;

public class LinkedListNode<T> {
    public T data;
    public LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }

    public LinkedListNode(int... ele) {
        if (ele.length == 0) return;
        LinkedListNode<Integer> dummy = new LinkedListNode(-1);
        LinkedListNode<Integer> root = dummy;
        for (int a : ele) {
            root.next = new LinkedListNode(a);
            root = root.next;
        }
        dummy = dummy.next;
        this.data = (T) dummy.data;
        this.next = (LinkedListNode<T>) dummy.next;
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

    @Override
    public String toString() {
        return "{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
