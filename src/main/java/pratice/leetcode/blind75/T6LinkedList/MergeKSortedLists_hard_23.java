package pratice.leetcode.blind75.T6LinkedList;

import pratice.pepcoding.beginner.AdvanceDS.HashmpHeap.WritePriorityQueueUsingHeap;

import java.util.PriorityQueue;

public class MergeKSortedLists_hard_23 {
    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            int n = lists.length;
            if (n == 0) return null;
            if (n == 1) return lists[0];

            ListNode result = mergeTwoSortedList(lists[0], lists[1]);
            for (int i = 2; i < n; i++)
                result = mergeTwoSortedList(result, lists[i]);
            return result;
        }

        private ListNode mergeTwoSortedList(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;

            if (list1.val < list2.val) {
                list1.next = mergeTwoSortedList(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoSortedList(list1, list2.next);
                return list2;
            }
        }

        public ListNode mergeKLists2(ListNode[] lists) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for(ListNode head: lists) {
                while (head != null) {
                    minHeap.add(head.val);
                    head = head.next;
                }
            }

            ListNode dummy = new ListNode(-1);
            ListNode head = dummy;
            while (!minHeap.isEmpty()){
                head.next = new ListNode(minHeap.remove());
                head = head.next;
            }
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode[] lists = ListNode.toNode(new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}});
        ListNode.print(sol.mergeKLists(lists));
        lists = ListNode.toNode(new int[][]{{1, 4, 5}, {1, 3, 4}, {2, 6}});
        ListNode.print(sol.mergeKLists2(lists));
    }
}
