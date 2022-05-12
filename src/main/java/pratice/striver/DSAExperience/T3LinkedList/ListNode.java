package pratice.striver.DSAExperience.T3LinkedList;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }

    public void print() {
        ListNode dummy = this;
        if (dummy == null)
            System.out.println("null");
        System.out.println();
        while (dummy != null) {
            System.out.print(dummy.val + " ");
            dummy = dummy.next;
        }
    }
}