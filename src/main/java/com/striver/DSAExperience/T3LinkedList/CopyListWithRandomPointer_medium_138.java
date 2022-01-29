package com.striver.DSAExperience.T3LinkedList;

import java.util.HashMap;

public class CopyListWithRandomPointer_medium_138 {
    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }

        public void print() {
            Node itr = this;
            if (itr == null)
                System.out.println("null");
            System.out.println();
            while (itr != null) {
                System.out.print(itr.val + "->" + (itr.random != null ? itr.random.val : null) + ", ");
                itr = itr.next;
            }
        }
    }

    static class LinkedList {
        Node head;
        Node[] index;

        public LinkedList(int[] ele) {
            this.index = new Node[ele.length];
            this.addElement(ele);
        }

        public Node addElement(int[] ele) {
            head = new Node(ele[0]);
            index[0] = head;
            Node ref = head;
            for (int i = 1; i < ele.length; i++) {
                ref.next = new Node(ele[i]);
                index[i] = ref.next;
                ref = ref.next;
            }
            return head;
        }

        public void appendRandom(Object[] obj) {
            for (int i = 0; i < obj.length; i++) {
                if (obj[i] != null)
                    index[i].random = index[(int) obj[i]];
            }
        }
    }

    static class Solution {
        // [Brute] O(2n), O(n) - copy each node to new list
        public Node copyRandomList1(Node head) {
            HashMap<Node, Node> map = new HashMap<>();
            Node itr = head;
            while (itr != null) {
                map.put(itr, new Node(itr.val));
                itr = itr.next;
            }
            itr = head;
            while (itr != null) {
                map.get(itr).next = map.get(itr.next);
                map.get(itr).random = map.get(itr.random);
                itr = itr.next;
            }
            return map.get(head);
        }

        // [Optimal] O(n), O(1) - create a deep copy node and append to its just next of original node
        public Node copyRandomList2(Node head) {
            Node itr = head;
            while (itr != null) {
                Node copy = new Node(itr.val);
                copy.next = itr.next;
                itr.next = copy;
                itr = itr.next.next;
            }
            itr = head;
            while (itr != null) {
                if (itr.random != null)
                    itr.next.random = itr.random.next;
                itr = itr.next.next;
            }

            itr = head;
            Node pseudoHead = new Node(0); // dummy node
            Node copy = pseudoHead;
            Node front = head;
            while (itr != null) {
                front = itr.next.next;

                copy.next = itr.next;
                copy = copy.next;

                itr.next = front;
                itr = front;
            }
            return pseudoHead.next;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        LinkedList list = new LinkedList(new int[]{7, 13, 11, 10, 1});
        list.appendRandom(new Object[]{null, 0, 4, 2, 0});
        Node res = sol.copyRandomList1(list.head);
        res.print();
        res = sol.copyRandomList2(list.head);
        res.print();
    }
}
