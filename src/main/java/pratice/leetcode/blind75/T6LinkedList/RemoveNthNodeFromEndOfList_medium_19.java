package pratice.leetcode.blind75.T6LinkedList;

import pratice.common.Out;

public class RemoveNthNodeFromEndOfList_medium_19 {
    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode fast = head;
            while (n-- != 0)
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
        ListNode head = ListNode.toNode(new int[]{1, 2});
        int n = 1;
        ListNode.print(sol.removeNthFromEnd(head, n));
    }
}
