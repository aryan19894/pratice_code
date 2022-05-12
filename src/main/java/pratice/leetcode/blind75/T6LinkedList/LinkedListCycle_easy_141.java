package pratice.leetcode.blind75.T6LinkedList;

import pratice.common.Out;

public class LinkedListCycle_easy_141 {
    static public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode();
        Out.print(sol.hasCycle(head));
    }
}
