package revise._2024.striver.linkedlist.mediumHardDLL;

import revise._2024.striver.linkedlist._nodes.DLL.random.Node;

import java.util.HashMap;
import java.util.Map;

public class CloneALinkedListWithRandomPointers {
    public static Node cloneLL(Node head) {
        if (head == null) return null;

        Map<Node, Node> nodeMap = new HashMap<>();
        Node temp = head;
        while (temp != null) {
            nodeMap.put(temp, new Node(temp.data));
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            Node copyNode = nodeMap.get(temp);
            copyNode.next = nodeMap.getOrDefault(temp.next, null);
            copyNode.random = nodeMap.getOrDefault(temp.random, null);
            temp = temp.next;
        }

        return nodeMap.get(head);
    }

    public static Node cloneLL2(Node head) {
        if (head == null) return null;

        insertCopyInBetween(head);
        connectRandomPointers(head);
        return getDeepCopyList(head);
    }

    private static Node getDeepCopyList(Node head) {
        Node dummy = new Node(-1);
        Node res = dummy;

        Node temp = head;
        while (temp != null) {
            res.next = temp.next;
            res = res.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummy.next;
    }

    private static void connectRandomPointers(Node head) {
        Node temp = head;
        while (temp != null) {
            temp.next.random = temp.random != null ?
                    temp.random.next : null;
            temp = temp.next.next;
        }
    }

    private static void insertCopyInBetween(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.data);

            copy.next = temp.next;
            temp.next = copy;

            temp = temp.next.next;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(7, 14, 21, 28);

        // Assigning random pointers
        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

        Node result = cloneLL2(head);
        if (result != null)
            result.print();
        else
            System.out.println("null");
    }
}
