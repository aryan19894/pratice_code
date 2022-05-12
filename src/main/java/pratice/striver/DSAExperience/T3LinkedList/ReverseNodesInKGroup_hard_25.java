package pratice.striver.DSAExperience.T3LinkedList;

import pratice.common.Out;

public class ReverseNodesInKGroup_hard_25 {
    static class Solution {
        // [Optimal] O(n), O(1) - find the len, group with k length node then perform reverse of each group list
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k == 1) return head;

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode cur = dummy, next = dummy, pre = dummy;

            int len = 0;
            while (cur.next != null) {
                len++;
                cur = cur.next;
            }

            while (len >= k) {
                cur = pre.next;
                next = cur.next;
                for (int i = 1; i < k; i++) {
                    cur.next = next.next;
                    next.next = pre.next;
                    pre.next = next;
                    next = cur.next;
                }
                pre = cur;
                len -= k;
            }

            return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        LinkedList l1 = new LinkedList(new int[]{1, 2, 3, 4, 5, 6, 7, 8});

        ListNode res = sol.reverseKGroup(l1.head, 3);
        Out.print(res);

    }
}