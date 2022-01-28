package com.striver.DSAExperience.T3LinkedList;

public class RotateList_medium_61 {
    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null || head.next == null || k == 0) return head;

            int len = 1;
            ListNode dummy = head;
            while (dummy.next != null) {
                len++;
                dummy = dummy.next;
            }
            dummy.next = head;
            k %= len;
            k = len - k;
            while (k-- > 0)
                dummy = dummy.next;

            head = dummy.next;
            dummy.next = null;

            return head;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        LinkedList l1 = new LinkedList(new int[]{1, 2, 3, 4, 5});

        ListNode res = sol.rotateRight(l1.head, 3);
        res.print();
    }
}
