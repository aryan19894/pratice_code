package revise._2022.striver.DSAExperience.T3LinkedList;

public class ReverseLinkedList_easy_206 {
    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode newNode = reverseList(head.next);
            head.next.next = head;
            head.next = null;
            return newNode;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));
        head.print();
        sol.reverseList(head).print();
    }
}
