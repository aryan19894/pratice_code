package revise._2024.striver.linkedlist.mediumHardDLL;

import common.Out;
import revise._2024.striver.linkedlist._nodes.DLL.Node;

import java.util.ArrayList;

public class FindPairsWithGivenSumInDLL {
    public static ArrayList<int[]> findPairs(Node head, int k) {
        ArrayList<int[]> pair = new ArrayList<>();
        if (head == null) return pair;

        Node temp1 = head;
        while (temp1 != null) {
            if (temp1.data > k) break;

            Node temp2 = temp1.next;
            while (temp2 != null && k - temp1.data >= temp2.data) {
                if (temp1.data + temp2.data == k)
                    pair.add(new int[]{temp1.data, temp2.data});
                temp2 = temp2.next;
            }

            temp1 = temp1.next;
        }

        return pair;
    }

    public static ArrayList<int[]> findPairs2(Node head, int k) {
        ArrayList<int[]> pair = new ArrayList<>();
        if (head == null || head.next == null) return pair;

        Node temp = head;
        while (temp.next != null) temp = temp.next;

        Node start = head;
        Node end = temp;
        while (start.data < end.data) {
            int sum = start.data + end.data;
            if (sum == k) {
                pair.add(new int[]{start.data, end.data});
                start = start.next;
                end = end.prev;
            } else if (sum < k)
                start = start.next;
            else
                end = end.prev;
        }

        return pair;
    }

    public static void main(String[] args) {
        Node head = new Node(1, 2, 3, 4, 9);
        Out.print(findPairs(head, 5));
        Out.print(findPairs2(head, 5));
    }
}
