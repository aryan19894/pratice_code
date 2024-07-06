package revise.striver.DSAExperience.T3LinkedList;

import pratice.common.Out;

public class ReverseNodesInKGroup_hard_25 {
    static class Solution {
        public ListNode reverseKGroup(ListNode head, int k) {
            if (head == null || k == 1) return head;
            int size = size(head);

            ListNode dummy = new ListNode(-1);
            dummy.next = head;
            ListNode curr = dummy, nxt = dummy, pre = dummy;

            while (size >= k) {
                curr = pre.next;
                nxt = curr.next;

                for (int i = 1; i < k; i++) {
                    curr.next = nxt.next;
                    nxt.next = pre.next;
                    pre.next = nxt;
                    nxt = curr.next;
                }

                pre = curr;
                size -= k;
            }
            return dummy.next;
        }

        private int size(ListNode node) {
            if (node == null) return 0;
            return 1 + size(node.next);
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1, 2, 3, 4, 5, 6, 7, 8);
        int k = 3;
        sol.reverseKGroup(head, k).print();
    }
}
