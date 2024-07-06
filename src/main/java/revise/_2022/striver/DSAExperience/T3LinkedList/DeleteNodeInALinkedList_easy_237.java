package revise._2022.striver.DSAExperience.T3LinkedList;

public class DeleteNodeInALinkedList_easy_237 {
    static class Solution {
        public void deleteNode(ListNode node) {
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(4, 5, 1, 9);
        sol.deleteNode(head.next);
        head.print();
    }
}
