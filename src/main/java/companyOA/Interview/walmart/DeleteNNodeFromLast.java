package companyOA.Interview.walmart;

class LinkedList {
    Node head;

    void deleteNode(int pos) {
        Node first = head; // head of the linked list
        Node second = head; // Nth node from the beginning

        for (int i = 0; i < pos; i++) {
            if (second.next == null) {
                if (i == pos - 1)
                    head = head.next;
                return;
            }
            second = second.next;
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        first.next = first.next.next;
    }

    public void push(int new_data) {
        Node new_node = new Node(new_data);
        new_node.next = head;
        head = new_node;
    }

    public void printList() {
        Node tnode = head;
        while (tnode != null) {
            System.out.print(tnode.data + " ");
            tnode = tnode.next;
        }
    }

    class Node {
        int data;
        Node next;

        public Node(int data) {
            super();
            this.data = data;
            this.next = null;
        }
    }
}

public class DeleteNNodeFromLast {

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();

        llist.push(1);
        llist.push(2);
        llist.push(3);
        llist.push(4);
        llist.push(5);

        System.out.println("\nCreated Linked list is:");
        llist.printList();

        int N = 2;
        llist.deleteNode(N);

        System.out.println("\nLinked List after Deletion is:");
        llist.printList();
    }

}
