package pratice.leetcode.blind75.T10Heap;

import pratice.common.Out;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists_hard_23 {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            for (ListNode head : lists) {
                while (head != null) {
                    minHeap.add(head.val);
                    head = head.next;
                }
            }


            ListNode dummy = new ListNode(-1);
            ListNode head = dummy;

            while (!minHeap.isEmpty()) {
                head.next = new ListNode(minHeap.remove());
                head = head.next;
            }
            return dummy.next;
        }

        public ListNode mergeKLists2(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            if (lists.length == 1) return lists[0];
            List<ListNode> nodes = new ArrayList<>(Arrays.asList(lists));

            while (nodes.size() != 1) {
                ListNode l1 = nodes.get(0);
                ListNode l2 = nodes.get(1);
                nodes.remove(0);
                nodes.remove(0);
                nodes.add(mergeTwoLists(l1, l2));
            }
            return nodes.get(0);
        }

        private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            while (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    curr.next = l1;
                    l1 = l1.next;
                } else {
                    curr.next = l2;
                    l2 = l2.next;
                }
                curr = curr.next;
            }

            curr.next = l1 == null ? l2 : l1;
            return dummy.next;
        }

        public ListNode mergeKLists3(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            if (lists.length == 1) return lists[0];
            return merge(lists, 0, lists.length - 1);
        }

        private ListNode merge(ListNode[] lists, int i, int j) {
            if (lists.length == 0) return null;
            if (i == j) return lists[i];
            int mid = i + (j - i) / 2;
            ListNode left = merge(lists, i, mid);
            ListNode right = merge(lists, mid + 1, j);

            ListNode dummy = new ListNode(-1);
            ListNode curr = dummy;
            while (left != null && right != null) {
                if (left.val <= right.val) {
                    curr.next = left;
                    left = left.next;
                } else {
                    curr.next = right;
                    right = right.next;
                }
                curr = curr.next;
            }

            curr.next = left == null ? right : left;
            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode[] lists = new ListNode[3];
        Out.print(sol.mergeKLists(lists));
    }
}
