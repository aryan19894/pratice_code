package pratice.leetcode.blind75.T6LinkedList;

import pratice.common.Out;

public class MergeTwoSortedLists_easy_21 {
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null) return list2;
            if (list2 == null) return list1;

            if (list1.val < list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }

        public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
            ListNode dummy = new ListNode();
            ListNode dDummy = dummy;
            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    dDummy.next = new ListNode(list1.val);
                    list1 = list1.next;
                } else {
                    dDummy.next = new ListNode(list2.val);
                    list2 = list2.next;
                }
                dDummy = dDummy.next;
            }

            if (list1 == null)
                dDummy.next = list2;
            if (list2 == null)
                dDummy.next = list1;

            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        Out.print(sol.mergeTwoLists(list1, list2));
        Out.print(sol.mergeTwoLists2(list1, list2));
    }
}
