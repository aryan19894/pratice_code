package com.striver.DSAExperience.T3LinkedList;/*
 * @lc app=leetcode id=876 lang=java
 *
 * [876] Middle of the Linked List
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

public class MiddleOfTheLinkedList_easy_876 {
    static class Solution {
        // [Brute] O(n)+O(n/2), SC: O(1) - find the length of list, then traverse to mid index
        public static ListNode middleNode1(ListNode head) {
            int len = 0;
            ListNode ref = head;
            while (ref != null) {
                len++;
                ref = ref.next;
            }
            int mid = (len / 2);
            for (int i = 0; i < mid; i++)
                head = head.next;
            return head;
        }

        // [Optimal] O(n/2), SC: O(1) - 2pointer method slow, fast
        public static ListNode middleNode2(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        ListNode head = list.addElement(new int[]{1, 2, 3, 4, 5});
        head = Solution.middleNode1(head);
        Printer.print(head);

        head = list.addElement(new int[]{1, 2, 3, 4, 5});
        head = Solution.middleNode2(head);
        Printer.print(head);

    }
}

// @lc code=end

