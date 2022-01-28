package com.striver.DSAExperience.T3LinkedList;/*
 * @lc app=leetcode id=21 lang=java
 *
 * [21] Merge Two Sorted Lists
 */

// @lc code=start

import com.common.Printer;

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
public class MergeTwoSortedLists_easy_21 {
    static class Solution {
        // [Brute] O(n+m), SC: O(n+m) - merge both sorted list to result list using extra space
        public static ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
            //Corner cases
            if (list1 == null && list2 == null)
                return null;
            if (list1 == null)
                return list2;
            if (list2 == null)
                return list1;

            ListNode dummy = new ListNode(0);
            ListNode res = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    res.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else if (list1.val > list2.val) {
                    res.next = new ListNode(list2.val);
                    list2 = list2.next;
                } else {
                    res.next = new ListNode(list1.val);
                    res = res.next;
                    list1 = list1.next;

                    res.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                res = res.next;
            }

            while (list1 != null) {
                res.next = new ListNode(list1.val);
                res = res.next;
                list1 = list1.next;
            }
            while (list2 != null) {
                res.next = new ListNode(list2.val);
                res = res.next;
                list2 = list2.next;
            }
            return dummy.next;
        }

        // [Better] O(n+m), SC: O(1) - merge both sorted list without using extra space
        public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
            //Corner cases
            if (l1 == null && l2 == null)
                return null;
            if (l1 == null)
                return l2;
            if (l2 == null)
                return l1;

            if (l1.val > l2.val) {
                ListNode swap = l1;
                l1 = l2;
                l2 = swap;
            }
            ListNode res = l1;
            while (l1 != null && l2 != null) {
                ListNode temp = null;
                while (l1 != null && l1.val <= l2.val) {
                    temp = l1;
                    l1 = l1.next;
                }
                temp.next = l2;
                //swapping the l1 and l2
                ListNode swap = l1;
                l1 = l2;
                l2 = swap;
            }
            return res;
        }
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(new int[]{1, 2, 3});
        LinkedList list2 = new LinkedList(new int[]{1, 2, 6, 7, 8});

        ListNode res = Solution.mergeTwoLists1(list1.head, list2.head);
        Printer.print(res);

        list1 = new LinkedList(new int[]{5, 7, 8, 9});
        list2 = new LinkedList(new int[]{3, 4, 8, 10});

        res = Solution.mergeTwoLists2(list1.head, list2.head);
        Printer.print(res);

    }
}

// @lc code=end

