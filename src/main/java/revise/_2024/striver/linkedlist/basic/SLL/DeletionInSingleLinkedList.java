package revise._2024.striver.linkedlist.basic.SLL;
import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class DeletionInSingleLinkedList {
    public static Node deleteHeadNode(Node head) {
        return head.next;
    }

    //2.23
    //Delete a Node in Single Linked List
    public static Node deleteKthNode(Node head, int k) {
        if (k <= 0) return head;
        if (k == 1) return head.next;
        k--;
        Node ref = head;
        while (--k > 0 && ref != null) ref = ref.next;
        if (k == 0)
            ref.next = ref.next.next;
        return head;
    }

    public static Node deleteByValue(Node head, int val) {
        if (head.data == val) return head.next;
        Node ref = head;
        boolean found = false;
        while (ref.next.next != null) {
            if (ref.next.data == val) {
                found = true;
                break;
            }
            ref = ref.next;
        }
        if (found)
            ref.next = ref.next.next;
        return head;
    }

    public static Node deleteLastNode(Node head) {
        Node ref = head;
        while (ref.next.next != null) ref = ref.next;
        ref.next = null;
        return head;
    }


    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 3, 4, 5};
        Node root = ArrayToLinkedList.constructLL(arr);

        Node deleteHeadNode = deleteHeadNode(root);
        System.out.println("deleteHeadNode: " + deleteHeadNode);

        Node deleteKthNode = deleteKthNode(root, 4);
        System.out.println("deleteKthNode: " + deleteKthNode);

        Node deleteByValue = deleteByValue(root, 3);
        System.out.println("deleteByValue: " + deleteByValue);

        Node deleteLastNode = deleteLastNode(root);
        System.out.println("deleteLastNode: " + deleteLastNode);
    }
}
