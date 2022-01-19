package com.striver.DSAExperience.Day6LinkedList;/*
 * @lc app=leetcode id=142 lang=java
 *
 * [142] Linked List Cycle II
 */

// @lc code=start

import com.striver.DSAExperience.Day5LinkedList.LinkedList;
import com.striver.DSAExperience.Day5LinkedList.ListNode;
import org.w3c.dom.NodeList;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */

public class LinkedListCycleII_medium_142 {
    static class Solution {

        public ListNode detectCycle(ListNode head) {
            if (head == null || head.next == null)
                return null;

            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (slow == fast) {
                    fast = head;
                    while (slow != fast) {
                        slow = slow.next;
                        fast = fast.next;
                    }
                    return fast;
                }
            }
            return null;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        LinkedList list = new LinkedList(new int[]{3, 2, 0, -4});
        list.makeCycle(1);
        ListNode res = sol.detectCycle(list.head);
        res.next = null;
        res.print();
    }
}
