package pratice.book.karumanchi.chapter2.recursion.leetcode;

import pratice.book.karumanchi.chapter2.recursion.ListNode;

public class AddTwoNumbers_medium_2 {
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            return add(l1, l2, 0);
        }

        private ListNode add(ListNode l1, ListNode l2, int carry) {
            if (l1 == null && l2 == null && carry == 0) return null;
            int sum = carry;
            if (l1 != null) sum += l1.val;
            if (l2 != null) sum += l2.val;

            ListNode root = new ListNode(sum % 10);
            root.next = add(l1 == null ? null : l1.next, l2 == null ? null : l2.next, sum > 9 ? 1 : 0);
            return root;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode l1 = ListNode.get(9, 9, 9, 9, 9, 9, 9);
        ListNode l2 = ListNode.get(9, 9, 9, 9);
        ListNode.print(sol.addTwoNumbers(l1, l2));
    }
}
