package com.striver.DSAExperience.T3LinkedList;/*
 * @lc app=leetcode id=234 lang=java
 *
 * [234] Palindrome Linked List
 */

// @lc code=start

import java.util.Stack;

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
public class PalindromeLinkedList_easy_234 {
    static class Solution {
        // [Optimal] O(3n/2), O(1) - find middle element, perform reverse of next half of list and
        // compare each element from first half.
        public boolean isPalindrome(ListNode head) {
            //finding middle element with 2pointer rule - slow, fast
            ListNode slow = head, fast = head;
            while (fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            //reversing the list after the slow pointer node
            slow.next = reverse(slow.next);
            //moving slow to next half
            slow = slow.next;

            while (slow != null) {
                if (head.val != slow.val)
                    return false;
                head = head.next;
                slow = slow.next;
            }

            return true;
        }

        public ListNode reverse(ListNode head) {
            ListNode newHead = null;
            while (head != null) {
                ListNode next = head.next;
                head.next = newHead;
                newHead = head;
                head = next;
            }
            return newHead;
        }

        // [Optimal] O(n), O(n/2) - find middle element, perform reverse of next half of list and
        // compare each element from first half.
        public boolean isPalindrome2(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;
            Stack<Integer> stack = new Stack<Integer>();

            while (fast != null && fast.next != null) {
                stack.push(slow.val);
                fast = fast.next.next;
                slow = slow.next;
            }

            //checks if the length of head is odd or even
            if (fast != null)
                // If it is odd, then we move the slow pointer to the next and start checking the value with below while loop.
                slow = slow.next;

            while (slow != null) {
                if (slow.val != stack.pop())
                    return false;
                slow = slow.next;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        LinkedList l1 = new LinkedList(new int[]{1, 2, 3, 3, 2, 1});

        System.out.println(sol.isPalindrome(l1.head));

        l1 = new LinkedList(new int[]{1, 2, 3, 3, 2, 1});

        System.out.println(sol.isPalindrome2(l1.head));
    }
}

// @lc code=end

