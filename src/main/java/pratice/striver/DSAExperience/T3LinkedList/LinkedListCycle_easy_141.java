package pratice.striver.DSAExperience.T3LinkedList;/*
 * @lc app=leetcode id=141 lang=java
 *
 * [141] Linked List Cycle
 */

// @lc code=start

import java.util.HashSet;

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
public class LinkedListCycle_easy_141 {
    static class Solution {
        // [Brute] TC, SC: O(n) - store each node into hash, check the duplicacy
        public boolean hasCycle1(ListNode head) {
            HashSet<Integer> set = new HashSet<>();
            while (head != null) {
                if (set.contains(head.hashCode()))
                    return true;
                set.add(head.hashCode());
                head = head.next;
            }
            return false;
        }

        // [Optimal] TC: O(n), SC: O(1) - will use 2pointer rule, slow(1step) and fast(2step)
        public boolean hasCycle2(ListNode head) {
            if (head == null || head.next == null)
                return false;
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast)
                    return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        LinkedList list = new LinkedList(new int[]{3, 2, 0, -4});
        list.makeCycle(1);
        System.out.println(sol.hasCycle1(list.head));
        System.out.println(sol.hasCycle2(list.head));
    }
}

// @lc code=end

