package pratice.book.karumanchi.chapter2.recursion.leetcode;

import pratice.book.karumanchi.chapter2.recursion.ListNode;
import pratice.common.Out;

public class PalindromeLinkedList_easy_234 {
    static class Solution {
        public boolean isPalindrome(ListNode head) {
            ListNode ref = copy(head);
            ListNode rev = reverse(ref);
            while (head.next != null && rev.next != null) {
                if (head.val != rev.val) return false;
                head = head.next;
                rev = rev.next;
            }
            return true;
        }

        public boolean isPalindrome2(ListNode head) {
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            slow.next = reverse(slow.next);
            slow = slow.next;

            while (slow != null) {
                if (head.val != slow.val) return false;
                head = head.next;
                slow = slow.next;
            }
            return true;
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode newNode = reverse(head.next);
            head.next.next = head;
            head.next = null;
            return newNode;
        }

        public ListNode copy(ListNode node) {
            if (node == null) return null;
            ListNode newNode = new ListNode(node.val);
            newNode.next = copy(node.next);
            return newNode;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(1))));

        Out.print(sol.isPalindrome(head));
        Out.print(sol.isPalindrome2(head));
    }
}
