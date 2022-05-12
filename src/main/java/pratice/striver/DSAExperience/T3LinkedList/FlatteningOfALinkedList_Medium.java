package pratice.striver.DSAExperience.T3LinkedList;

public class FlatteningOfALinkedList_Medium {
    static class Node {
        public int val;
        public Node next;
        public Node bottom;

        Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node bottom) {
            this.val = val;
            this.next = next;
            this.bottom = bottom;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", next=" + next +
                    ", bottom=" + bottom +
                    '}';
        }

        public void print() {
            Node dummy = this;
            if (dummy == null)
                System.out.println("null");
            System.out.println();
            while (dummy != null) {
                System.out.print(dummy.val + " ");
                dummy = dummy.bottom;
            }
        }
    }

    static class LinkedList {
        public Node head;
        private Node tail;
        public int size = 0;

        public LinkedList() {
        }

        public LinkedList(int[] ele) {
            this.addElementAsBottom(ele);
        }

        private void addElementAsBottom(int[] ele) {
            this.head = new Node(ele[0]);
            Node ref = this.head;

            for (int i = 1; i < ele.length; ++i) {
                ref.bottom = new Node(ele[i]);
                ref = ref.bottom;
            }

            this.size += ele.length;
        }

        public Node addElement(int[] ele) {
            this.head = new Node(ele[0]);
            Node ref = this.head;

            for (int i = 1; i < ele.length; ++i) {
                ref.next = new Node(ele[i]);
                this.tail = ref = ref.next;
            }

            this.size += ele.length;
            return this.head;
        }
    }

    static Node flatten(Node root) {
        if (root != null && root.next != null) {
            root.next = flatten(root.next);
            root = mergeTwoLists(root, root.next);
        }
        return root;
    }

    static Node mergeTwoLists(Node a, Node b) {
        Node temp = new Node(0);

        Node res;
        for (res = temp; a != null && b != null; temp = temp.bottom) {
            if (a.val < b.val) {
                temp.bottom = a;
                a = a.bottom;
            } else {
                temp.bottom = b;
                b = b.bottom;
            }
        }

        if (a != null) {
            temp.bottom = a;
        } else {
            temp.bottom = b;
        }

        return res.bottom;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(new int[]{5, 7, 8, 30});
        LinkedList l2 = new LinkedList(new int[]{10, 20});
        LinkedList l3 = new LinkedList(new int[]{19, 22, 50});
        LinkedList l4 = new LinkedList(new int[]{28, 35, 40, 45});
        l3.head.next = l4.head;
        l2.head.next = l3.head;
        l1.head.next = l2.head;
        Node res = flatten(l1.head);
        res.print();
    }
}
