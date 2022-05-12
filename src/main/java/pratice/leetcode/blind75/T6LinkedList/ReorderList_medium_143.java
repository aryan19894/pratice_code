package pratice.leetcode.blind75.T6LinkedList;

public class ReorderList_medium_143 {
    static class Solution {
        public void reorderList(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            slow = reverse(slow);
            fast = head;

            while (slow.next != null) {
                ListNode p1 = fast.next;
                ListNode p2 = slow.next;
                fast.next = slow;
                slow.next = p1;
                fast = p1;
                slow = p2;
            }
        }

        private ListNode reverse(ListNode head) {
            ListNode back = null;
            ListNode front = head;
            ListNode curr = head;
            while (curr != null) {
                front = front.next;
                curr.next = back;
                back = curr;
                curr = front;
            }
            return back;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = ListNode.toNode(new int[]{1, 2, 3, 4, 5});
        sol.reorderList(head);
        ListNode.print(head);
    }
}
