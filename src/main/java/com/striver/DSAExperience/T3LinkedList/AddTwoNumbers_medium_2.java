package com.striver.DSAExperience.T3LinkedList;/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 */

// @lc code=start

import com.common.Out;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbers_medium_2 {
    static class Solution {
        // [Optimal] O(max(m,n)), SC: O(max(m,n)) - using seperate loop for each list
        public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
            //Corner cases
            if (l1 == null && l2 == null)
                return null;
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;

            ListNode dummy = new ListNode(0);
            ListNode temp = dummy;
            int sum = 0, carry = 0;
            while (l1 != null && l2 != null) {
                sum = l1.val + l2.val + carry;
                carry = sum / 10;
                sum %= 10;

                temp.next = new ListNode(sum);
                temp = temp.next;
                l1 = l1.next;
                l2 = l2.next;
            }

            while (l1 != null) {
                sum = l1.val + carry;
                carry = sum / 10;
                sum %= 10;

                temp.next = new ListNode(sum);
                temp = temp.next;
                l1 = l1.next;
            }
            while (l2 != null) {
                sum = l2.val + carry;
                carry = sum / 10;
                sum %= 10;

                temp.next = new ListNode(sum);
                temp = temp.next;
                l2 = l2.next;
            }
            //carry scenario
            if (carry != 0)
                temp.next = new ListNode(carry);
            return dummy.next;
        }

        // [Optimal] O(max(m,n)), SC: O(max(m,n)) - using single loop for all list
        public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
            //Corner cases
            if (l1 == null && l2 == null)
                return null;
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;

            ListNode dummy = new ListNode(0);
            ListNode temp = dummy;
            int carry = 0;
            while (l1 != null || l2 != null || carry == 1) {
                int sum = 0;
                if (l1 != null) {
                    sum += l1.val;
                    l1 = l1.next;
                }
                if (l2 != null) {
                    sum += l2.val;
                    l2 = l2.next;
                }

                sum += carry;
                carry = sum / 10;
                sum %= 10;

                temp.next = new ListNode(sum);
                temp = temp.next;
            }

            return dummy.next;
        }

        // [Optimal] O(max(m,n)), SC: O(max(m,n)) - using multiple loop for each list and use seperate list
        public static ListNode addTwoNumbers3(ListNode l1, ListNode l2) {
            //Corner cases
            if (l1 == null && l2 == null)
                return null;
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;

            int carry = 0;
            ListNode l3 = null;
            ListNode l3Head = null;
            while (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + carry;
                carry = sum / 10;
                sum %= 10;

                if (l3 != null) {
                    l3.next = new ListNode(sum);
                    l3 = l3.next;
                } else {
                    l3 = new ListNode(sum);
                    l3Head = l3;
                }
                l1 = l1.next;
                l2 = l2.next;
            }

            ListNode pendingList = l1 == null ? (l2 == null ? null : l2) : l1;

            while (pendingList != null) {
                if (carry > 0) {
                    int n = pendingList.val + carry;
                    l3.next = new ListNode(n % 10);
                    carry = n / 10;
                    l3 = l3.next;
                    pendingList = pendingList.next;
                } else {
                    l3.next = pendingList;
                    break;
                }
            }
            //carry scenario
            if (carry != 0)
                l3.next = new ListNode(carry);
            return l3Head;
        }


    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(new int[]{2, 4, 3});
        LinkedList l2 = new LinkedList(new int[]{5, 6, 7, 9});

        ListNode res = Solution.addTwoNumbers1(l1.head, l2.head);
        Out.print(res);

        res = Solution.addTwoNumbers2(l1.head, l2.head);
        Out.print(res);

        res = Solution.addTwoNumbers3(l1.head, l2.head);
        Out.print(res);
    }
}

// @lc code=end

