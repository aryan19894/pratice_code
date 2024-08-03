package revise._2024.striver.linkedlist.basic.SLL;
import revise._2024.striver.linkedlist._nodes.SLL.Node;

public class InsertionInSingleLinkedList {

    public static Node insertAtHeadNode(Node head, int data) {
        return new Node(data, head);
    }

    //2.23
    //Insert a Node in Single Linked List
    public static Node insertAtKthNode(Node head, int k, int data) {
        if (k <= 0) return head;
        Node temp = new Node(data);
        temp.next = head;
        if (k == 1) return temp;

        k--;
        Node ref = head;
        while (--k > 0 && ref != null) ref = ref.next;
        if (k == 0) {
            temp.next = ref.next;
            ref.next = temp;
        }
        return head;
    }

    public static Node insertAtBeforeValue(Node head, int key, int data) {
        if (head.data == key) return new Node(data, head);

        Node ref = head;
        boolean found = false;
        while (ref.next != null) {
            if (ref.next.data == key) {
                found = true;
                break;
            }
            ref = ref.next;
        }
        if (found)
            ref.next = new Node(data, ref.next);
        return head;
    }

    public static Node insertAtLastNode(Node head, int data) {
        if (head == null) return new Node(data);

        Node ref = head;
        while (ref.next != null) ref = ref.next;
        ref.next = new Node(data);
        return head;
    }

    //1.99
    static public Node insertInMiddle(Node head, int x) {
        if (head == null) return new Node(x);
        int count = 0;
        Node ref = head;
        while (ref != null) {
            count++;
            ref = ref.next;
        }
        return insertAtKthNode(head, (count + 3) / 2, x);
    }

    static public Node insertInMiddle2(Node head, int x) {
        if (head == null) return new Node(x);
        int count = 0;
        Node ref = head;
        while (ref != null) {
            count++;
            ref = ref.next;
        }

        int k = (count + 3) / 2;
        if (k <= 0) return head;
        Node temp = new Node(x);
        temp.next = head;
        if (k == 1) return temp;

        k--;
        ref = head;
        while (--k > 0 && ref != null) ref = ref.next;
        if (k == 0) {
            temp.next = ref.next;
            ref.next = temp;
        }
        return head;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr = {5,4};
        Node root = ArrayToLinkedList.constructLL(arr);

        Node insertAtHeadNode = insertAtHeadNode(root, 11);
        System.out.println("insertAtHeadNode: " + insertAtHeadNode);

        Node insertAtKthNode = insertAtKthNode(root, 6, 11);
        System.out.println("insertAtKthNode: " + insertAtKthNode);

        Node insertAtBeforeValue = insertAtBeforeValue(root, 5, 11);
        System.out.println("insertAtBeforeValue: " + insertAtBeforeValue);

        Node insertAtLastNode = insertAtLastNode(root, 340);
        System.out.println("insertAtLastNode: " + insertAtLastNode);

        Node insertInMiddle = insertInMiddle2(root, 1);
        System.out.println("insertInMiddle: " + insertInMiddle);
    }
}

