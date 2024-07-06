package revise._2022.striver.DSAExperience.T3LinkedList;

public class RemoveNthNodeFromEndOfList_medium_19 {
	static class Solution {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fast = head;
            while (n-- > 0)
                fast = fast.next;

            if(fast == null) return head.next;

            ListNode slow = head;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next.next;
            return head;
	    }
	}
	public static void main(String[] args) {
		Solution sol = new Solution();
        ListNode head = new ListNode(1, 2, 3, 4, 5);
		int n = 2;
        sol.removeNthFromEnd(head, n).print();
	}
}
