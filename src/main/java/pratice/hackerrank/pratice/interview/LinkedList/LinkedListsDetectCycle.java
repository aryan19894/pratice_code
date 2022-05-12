// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LinkedListsDetectCycle.java

package pratice.hackerrank.pratice.interview.LinkedList;

import java.io.PrintStream;
import java.util.*;

public class LinkedListsDetectCycle
{
    static class SinglyLinkedList
    {

        public void insertNode(int nodeData)
        {
            Node node = new Node(nodeData);
            if(head == null)
                head = node;
            else
                tail.next = node;
            tail = node;
        }

        public Node head;
        public Node tail;

        public SinglyLinkedList()
        {
            head = null;
            tail = null;
        }
    }

    static class Node
    {

        public int data;
        public Node next;

        public Node(int nodeData)
        {
            data = nodeData;
            next = null;
        }
    }


    public LinkedListsDetectCycle()
    {
    }

    static boolean hasCycle(Node head)
    {
        Node n = head;
        List r = new ArrayList();
        int i = 0;
        if(head == null)
            return false;
        for(; n != null; n = n.next)
        {
            if(r.contains(n))
                return true;
            r.add(i++, n);
        }

        return false;
    }

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        SinglyLinkedList llist1 = new SinglyLinkedList();
        int llistCount1 = scanner.nextInt();
        for(int j = 0; j < llistCount1; j++)
        {
            int llistItem = scanner.nextInt();
            llist1.insertNode(llistItem);
        }

        int res = !hasCycle(llist1.head) ? 0 : 1;
        System.out.println(res);
    }
}
