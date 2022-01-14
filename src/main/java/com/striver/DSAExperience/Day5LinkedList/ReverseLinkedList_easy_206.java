package com.striver.DSAExperience.Day5LinkedList;

import com.common.Printer;

public class ReverseLinkedList_easy_206 {
    static class Solution {
        //TC: O(n), SC: O(1)
        //iterative approach - full iteration
        public static ListNode reverseList1(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            }
            return newHead;
        }

        //recursive approach
        public static ListNode reverseList2(ListNode head) {
            if (head == null || head.next == null)
                return head;

            ListNode rest = reverseList2(head.next);
            head.next.next = head;
            head.next = null;

            return rest;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        ListNode head = list.addElement(new int[]{1, 2, 3, 4, 5});
        head = Solution.reverseList1(head);
        Printer.print(head);

        head = list.addElement(new int[]{1, 2, 3, 4, 5});
        head = Solution.reverseList2(head);
        Printer.print(head);
    }
}

// @lc code=end

