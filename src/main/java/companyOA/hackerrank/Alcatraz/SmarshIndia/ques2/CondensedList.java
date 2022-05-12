package companyOA.hackerrank.Alcatraz.SmarshIndia.ques2;

import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;

public class CondensedList {
	static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep) throws IOException {
        while (node.next != null) {
        	System.out.print(node.data);
            node = node.next;

            if (node.next != null) {
            	System.out.print(sep);
            }
        }
    }
    
	public static SinglyLinkedListNode condense(SinglyLinkedListNode head) {
		HashSet<Integer> hs = new HashSet<>(); 
		SinglyLinkedListNode c = head;
		SinglyLinkedListNode prev = null; 
		while(c.next != null) {
			if(!hs.contains(c.data)) {
				hs.add(c.data);
				prev = c;
			} else {
				prev.next = c.next; 
			}
			c = c.next;
		}
		return head;
	}
	
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		SinglyLinkedList llist = new SinglyLinkedList();
    	int llistCount = scanner.nextInt();
    	for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            llist.insertNode(llistItem);
        }
    	
        SinglyLinkedListNode llist_head = condense(llist.head);

        printSinglyLinkedList(llist_head, "->");
        scanner.close();
	}

}
