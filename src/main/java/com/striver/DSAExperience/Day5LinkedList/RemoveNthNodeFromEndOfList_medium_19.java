package com.striver.DSAExperience.Day5LinkedList;/*
 * @lc app=leetcode id=19 lang=java
 *
 * [19] Remove Nth Node From End of List
 */

// @lc code=start

import com.common.Printer;
import com.striver.DSAExperience.Day5LinkedList.LinkedList;
import com.striver.DSAExperience.Day5LinkedList.ListNode;
import com.striver.DSAExperience.Day5LinkedList.MiddleOfTheLinkedList_easy_876;

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
public class RemoveNthNodeFromEndOfList_medium_19 {
    static class Solution {
        // [Brute] O(2n), SC: O(1) - find the length of list, find the nth node from front and perform deletion
        // [Optimal] O(n), SC: O(1) - 2pointer method slow, fast with dummy head
        public static ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode dummy = new ListNode();
            dummy.next = head;
            ListNode slow = dummy;
            ListNode fast = dummy;

            for (int i = 1; i <= n; i++)
                fast = fast.next;

            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }

            slow.next = slow.next.next;
            return dummy.next;
        }

    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        ListNode head = list.addElement(new int[]{2, 4, 1, 3, 5, 6});
        head = Solution.removeNthFromEnd(head, 6);
        Printer.print(head);

    }
}

// @lc code=end

