package revise._2024.striver.linkedlist.mergeList;

import lombok.Getter;
import revise._2024.striver.linkedlist._nodes.SLL.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MergeKSortedLists {
    static class Pair {
        @Getter
        int data;
        Node node;

        public Pair(int data, Node node) {
            this.data = data;
            this.node = node;
        }
    }

    public static Node mergeKSortedLists(ArrayList<Node> nodeList) {
        if (nodeList == null || nodeList.isEmpty()) return null;
        if (nodeList.size() == 1) return nodeList.get(0);

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a,b)->Integer.compare(a.data, b.data)
        );

        for (Node ele : nodeList)
            pq.add(new Pair(ele.data, ele));

        Node dummy = new Node(-1);
        Node temp = dummy;
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (curr.node.next != null)
                pq.add(new Pair(curr.node.next.data, curr.node.next));

            temp.next = curr.node;
            temp = temp.next;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        ArrayList<Node> nodeList = new ArrayList<>(
                Arrays.asList(
                        new Node(12, 19, 20, 29),
                        new Node(7, 26, 31, 33),
                        new Node(15),
                        new Node(9, 16, 18),
                        new Node(5, 8, 21, 42),
                        new Node(50),
                        new Node(13, 17, 23, 37)
                )
        );

        Node result = mergeKSortedLists(nodeList);
        if (result != null)
            result.print();
        else
            System.out.println("null");
    }
}
