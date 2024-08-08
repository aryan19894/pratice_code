package revise._2024.striver.linkedlist.basic.DLL;
import revise._2024.striver.linkedlist._nodes.DLL.Node;

public class InsertionInDoublyLinkedList {

    public static Node insertAtHeadNode(Node head, int k) {
        Node temp = new Node(k);
        if (head == null) return temp;
        head.prev = temp;
        temp.next = head;
        return temp;
    }

    public static Node insertAtKthNode(Node head, int k, int data) {
        if (k <= 0) return head;
        Node temp = new Node(data);
        if (k == 1) {
            head.prev = temp;
            temp.next = head;
            return temp;
        }

        k--;
        Node ref = head;
        while (--k > 0 && ref.next != null) ref = ref.next;
        if (k == 0) {
            temp = new Node(ref, data, ref.next);
            if (ref.next != null)
                ref.next.prev = temp;
            ref.next = temp;
        }
        return head;
    }

    public static Node insertAtAfterValue(Node head, int key, int data) {
        Node ref = head;
        boolean found = false;
        while (ref != null) {
            if (ref.data == key) {
                found = true;
                break;
            }
            ref = ref.next;
        }
        if (found) {
            Node temp = new Node(ref, data, ref.next);
            if (ref.next != null)
                ref.next.prev = temp;
            ref.next = temp;
        }
        return head;
    }

    public static Node insertAtLastNode(Node head, int data) {
        if (head == null) return new Node(data);

        Node ref = head;
        while (ref.next != null) ref = ref.next;
        Node temp = new Node(data);
        temp.prev = ref;
        ref.next = temp;
        return head;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 3, 4};
        Node root = IntroToDoublyLinkedList.constructDLL(arr);

        Node insertAtHeadNode = insertAtHeadNode(root, 20);
        System.out.println("insertAtHeadNode: " + insertAtHeadNode);

        Node insertAtKthNode = insertAtKthNode(root, 2, 11);
        System.out.println("insertAtKthNode: " + insertAtKthNode);

        Node insertAtBeforeValue = insertAtAfterValue(root, 6, 11);
        System.out.println("insertAtBeforeValue: " + insertAtBeforeValue);

        Node insertAtLastNode = insertAtLastNode(root, 340);
        System.out.println("insertAtLastNode: " + insertAtLastNode);
    }
}

