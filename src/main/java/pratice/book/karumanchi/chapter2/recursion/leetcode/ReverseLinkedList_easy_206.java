package pratice.book.karumanchi.chapter2.recursion.leetcode;

import pratice.book.karumanchi.chapter2.recursion.ListNode;

public class ReverseLinkedList_easy_206 {
    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode newNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newNode;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3)));

        ListNode.print(sol.reverseList(head));
    }
}
