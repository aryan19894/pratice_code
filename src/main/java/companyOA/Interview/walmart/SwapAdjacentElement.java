package companyOA.Interview.walmart;

public class SwapAdjacentElement {

	static class Node {
		int data;
		Node next;
	}

	static Node head = null;

	static Node swapPair(Node head) {
		if (head == null || head.next == null)
			return head;

		Node curr = head.next.next;
		Node prev = head;
		head = head.next;
		head.next = prev;

		while (curr != null && curr.next != null) {
			prev.next = curr.next;
			prev = curr;
			Node next = curr.next.next;
			curr.next.next = curr;
			curr = next;
		}

		prev.next = curr;
		return head;
	}

	static void addFirst(int newData) {
		Node newNode = new Node();
		newNode.data = newData;
		newNode.next = head;
		head = newNode;
	}

	static void print(Node node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		addFirst(5);
		addFirst(4);
		addFirst(3);
		addFirst(2);
		addFirst(1);

		System.out.println("Before Swapping ");
		print(head);
		Node start = swapPair(head);
		System.out.println("\nAfter Swapping ");
		print(start);

	}

}
