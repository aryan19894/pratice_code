package revise._2022.striver.DSAExperience.T3LinkedList;

public class MergeTwoSortedLists_easy_21 {
    static class Solution {
        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) return null;
            if (list1 == null) return list2;
            if (list2 == null) return list1;

            if (list1.val <= list2.val) {
                list1.next = mergeTwoLists(list1.next, list2);
                return list1;
            } else {
                list2.next = mergeTwoLists(list1, list2.next);
                return list2;
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode list1 = new ListNode(1, 2, 4);
        ListNode list2 = new ListNode(1, 3, 4);

        sol.mergeTwoLists(list1, list2).print();
    }
}
