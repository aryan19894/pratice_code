package revise.striver.DSAExperience.T3LinkedList;

import pratice.common.Out;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle_easy_141 {
    static public class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) return false;
            Set<ListNode> hash = new HashSet<>();

            while (head != null) {
                if (!hash.isEmpty() && hash.contains(head)) return true;
                hash.add(head);
                head = head.next;
            }

            return false;
        }

        public boolean hasCycle2(ListNode head) {
            if (head == null || head.next == null) return false;

            ListNode slow = head, fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(3, 2, 0, 4);
        head.makeCyclic(1);
        Out.print(sol.hasCycle(head));
        Out.print(sol.hasCycle2(head));
    }
}
