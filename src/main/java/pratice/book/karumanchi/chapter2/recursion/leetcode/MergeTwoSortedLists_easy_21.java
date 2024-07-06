package pratice.book.karumanchi.chapter2.recursion.leetcode;

import pratice.book.karumanchi.chapter2.recursion.ListNode;

public class MergeTwoSortedLists_easy_21 {
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            ListNode result = new ListNode(-1);
            mergeRecursive(list1, list2, result);
            return result.next;
        }

        private void mergeRecursive(ListNode l1, ListNode l2, ListNode res) {
            if (l1 == null && l2 == null) return;
            if (l1 == null) {
                res.next = l2;
                return;
            }
            if (l2 == null) {
                res.next = l1;
                return;
            }

            if (l1.val == l2.val) {
                res.next = new ListNode(l1.val, new ListNode(l2.val));
                mergeRecursive(l1.next, l2.next, res.next.next);
            } else if (l1.val < l2.val) {
                res.next = new ListNode(l1.val);
                mergeRecursive(l1.next, l2, res.next);
            } else {
                res.next = new ListNode(l2.val);
                mergeRecursive(l1, l2.next, res.next);
            }
        }

        public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;

            if (list1.val < list2.val) {
                list1.next = mergeTwoLists2(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists2(list1, list2.next);
                return list2;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode list1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(3)));
        ListNode list2 = new ListNode(1,
                new ListNode(2,
                        new ListNode(6,
                                new ListNode(7,
                                        new ListNode(8)))));

        ListNode.print(sol.mergeTwoLists(list1, list2));
        ListNode.print(sol.mergeTwoLists2(list1, list2));
    }


}
