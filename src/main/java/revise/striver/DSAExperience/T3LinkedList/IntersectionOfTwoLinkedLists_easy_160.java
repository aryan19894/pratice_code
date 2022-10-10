package revise.striver.DSAExperience.T3LinkedList;

public class IntersectionOfTwoLinkedLists_easy_160 {
    static public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int len1 = getLength(headA), len2 = getLength(headB);

            for (int i = 0; i < Math.abs(len1 - len2); i++) {
                if (len1 > len2) headA = headA.next;
                else if (len1 < len2) headB = headB.next;
            }

            while (headA != headB) {
                headA = headA.next;
                headB = headB.next;
            }

            return headA;
        }

        private int getLength(ListNode node) {
            if (node == null) return 0;
            return 1 + getLength(node.next);
        }

        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            if (headA == null || headA == null) return null;

            ListNode l1 = headA, l2 = headB;
            while (l1 != l2) {
                l1 = l1.next;
                l2 = l2.next;

                if (l1 == null && l2 == null) return null;
                if (l1 == null) l1 = headB;
                else if (l2 == null) l2 = headA;
            }

            return l1 == l2 ? l1 : null;
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        ListNode headA = new ListNode(4, 1);
        ListNode headB = new ListNode(5, 6, 1);
        ListNode.makeIntersect(headA, headB, 8, 4, 5);

        sol.getIntersectionNode(headA, headB).print();
        sol.getIntersectionNode2(headA, headB).print();
    }
}
