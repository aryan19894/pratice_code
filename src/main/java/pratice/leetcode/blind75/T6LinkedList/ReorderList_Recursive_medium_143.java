package pratice.leetcode.blind75.T6LinkedList;

public class ReorderList_Recursive_medium_143 {
    static class Solution {
        public void reorderList(ListNode head) {
            ListNode middleNode = getMiddleNode(head);
            ListNode end = reverse(middleNode);

            reorder(head, end);
        }

        private void reorder(ListNode start, ListNode end) {
            if (start == end) return;
            if (start == null || end == null) return;

            ListNode a = start.next;
            ListNode b = end.next;
            start.next = end;
            end.next = end == a ? null : a;

            reorder(a, b);
        }

        private ListNode getMiddleNode(ListNode node) {
            ListNode slow = node;
            ListNode fast = node;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private ListNode reverse(ListNode head) {
            if (head == null) return null;

            ListNode prev = null;
            ListNode curr = head;
            ListNode n = head.next;

            while (curr != null) {
                curr.next = prev;
                prev = curr;
                curr = n;
                n = n == null ? null : n.next;
            }
            return prev;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = ListNode.toNode(new int[]{1, 2, 3, 4, 5});
        sol.reorderList(head);
        ListNode.print(head);
    }
}
