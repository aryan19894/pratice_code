package revise._2024.striver.linkedlist.basic.DLL;
import revise._2024.striver.linkedlist._nodes.DLL.Node;

public class DeletionInDoublyLinkedList {
    public static Node deleteHeadNode(Node head) {
        if (head == null || head.next == null) return null;
        head.next.prev = null;
        return head.next;
    }

    //2.23
    //Delete a Node in Single Linked List
    public static Node deleteKthNode(Node head, int k) {
        if (head == null) return null;
        if (k <= 0) return head;
        if (k == 1) return head.next;

        k--;
        Node ref = head;
        while (--k > 0 && ref.next.next != null) ref = ref.next;
        if (k == 0) {
            if (ref.next.next == null)
                ref.next.prev = null;
            else ref.next.next.prev = ref;

            ref.next = ref.next.next;
        }
        return head;
    }

    public static Node deleteByValue(Node head, int k) {
        if (head == null) return null;
        if (head.data == k) return head.next;

        Node ref = head;
        boolean found = false;
        while (ref.next != null) {
            if (ref.next.data == k) {
                found = true;
                break;
            }
            ref = ref.next;
        }
        if (found) {
            if (ref.next.next == null)
                ref.next.prev = null;
            else ref.next.next.prev = ref;

            ref.next = ref.next.next;
        }
        return head;
    }

    public static Node deleteLastNode(Node head) {
        if (head == null || head.next == null) return null;

        Node ref = head;
        while (ref.next.next != null) ref = ref.next;
        ref.next.prev = null;
        ref.next = null;
        return head;
    }


    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 4, 5};
        Node root = IntroToDoublyLinkedList.constructDLL(arr);

        Node deleteHeadNode = deleteHeadNode(root);
        System.out.println("deleteHeadNode: " + deleteHeadNode);

        Node deleteKthNode = deleteKthNode(root, 5);
        System.out.println("deleteKthNode: " + deleteKthNode);

        Node deleteByValue = deleteByValue(root, 5);
        System.out.println("deleteByValue: " + deleteByValue);

        Node deleteLastNode = deleteLastNode(root);
        System.out.println("deleteLastNode: " + deleteLastNode);
    }
}
