package pratice.striver.DSAExperience.T3LinkedList;/*
 * @lc app=leetcode id=160 lang=java
 *
 * [160] Intersection of Two Linked Lists
 */

// @lc code=start

import pratice.common.Out;

import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) {
 * val = x;
 * next = null;
 * }
 * }
 */
public class IntersectionOfTwoLinkedLists_easy_160 {
    static public class Solution {
        // [Brute] O(n*m) - compare each node to both list one by one
        // [Better] O(2n), O(n) - store first list node hash value to hashtable and iterate the list2 and compare node.
        public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
            HashSet<Integer> table = new HashSet<>();
            ListNode l1 = headA;
            while (l1 != null) {
                table.add(l1.hashCode());
                l1 = l1.next;
            }

            ListNode l2 = headB;
            while (l2 != null) {
                if (table.contains(l2.hashCode()))
                    return l2;
                l2 = l2.next;
            }
            return null;
        }

        // [Optimal1] O(max(m,n)), SC: O(max(m,n)) -
        // find length of both list, find difference of both list length
        // traverse again 1by1 node after difference traversal
        public ListNode getIntersectionNode2(ListNode l1, ListNode l2) {
            int len1 = 0, len2 = 0;
            ListNode headA = l1, headB = l2;
            while (headA != null || headB != null) {
                if (headA != null) {
                    len1++;
                    headA = headA.next;
                }
                if (headB != null) {
                    len2++;
                    headB = headB.next;
                }
            }
            ListNode dummy = len1 > len2 ? l1 : l2;
            for (int i = 1; i <= Math.abs(len1 - len2); i++) {
                dummy = dummy.next;
            }

            if (len1 > len2)
                l1 = dummy;
            else
                l2 = dummy;

            while (l1 != null && l2 != null) {
                if (l1.hashCode() == l2.hashCode())
                    return l1;
                l1 = l1.next;
                l2 = l2.next;
            }
            return null;
        }

        // [Optimal3] O(2m), SC: O(1) -
        // find length of both list by traversing 2 times each node 1by1
        // traverse again 1by1 node after difference traversal
        public ListNode getIntersectionNode3(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null)
                return null;
            ListNode headA = l1, headB = l2;
            while (l1 != l2) {
                l1 = l1.next;
                l2 = l2.next;

                if (l1 == null && l2 == null)
                    return null;

                if (l1 == null)
                    l1 = headB;
                else if (l2 == null)
                    l2 = headA;

            }
            if (l1.hashCode() == l2.hashCode())
                return l1;
            return null;
        }

        // [Similar Optimal3] O(2m), SC: O(1)
        // more less code compare to getIntersectionNode3()
        public ListNode getIntersectionNode4(ListNode l1, ListNode l2) {
            if (l1 == null || l2 == null)
                return null;
            ListNode headA = l1, headB = l2;
            while (l1 != l2) {
                l1 = l1 == null ? headB : l1.next;
                l2 = l2 == null ? headA : l2.next;
            }
            return l1;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        LinkedList l1 = new LinkedList(new int[]{1, 2});
        LinkedList l2 = new LinkedList(new int[]{2, 8, 1, 3});
        LinkedList common = new LinkedList(new int[]{8, 7, 6});

        l1.addLast(common);
        l2.addLast(common);

        ListNode res = sol.getIntersectionNode1(l1.head, l2.head);
        Out.print(res);

        res = sol.getIntersectionNode2(l1.head, l2.head);
        Out.print(res);

        res = sol.getIntersectionNode3(l1.head, l2.head);
        Out.print(res);

        res = sol.getIntersectionNode4(l1.head, l2.head);
        Out.print(res);
    }
}

// @lc code=end

