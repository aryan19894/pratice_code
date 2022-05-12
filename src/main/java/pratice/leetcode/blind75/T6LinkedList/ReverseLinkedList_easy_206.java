package pratice.leetcode.blind75.T6LinkedList;

import pratice.common.Out;

public class ReverseLinkedList_easy_206 {
    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null)
                return head;
            ListNode root = reverseList(head.next);
            head.next.next = head;
            head.next = null;

            return root;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1);
        Out.print(sol.reverseList(head));
    }
}
