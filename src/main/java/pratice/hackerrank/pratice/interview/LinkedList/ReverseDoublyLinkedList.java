// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ReverseDoublyLinkedList.java

package pratice.hackerrank.pratice.interview.LinkedList;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class ReverseDoublyLinkedList
{
    static class DoublyLinkedList
    {

        public void insertNode(int nodeData)
        {
            DoublyLinkedListNode node = new DoublyLinkedListNode(nodeData);
            if(head == null)
            {
                head = node;
            } else
            {
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
        }

        public DoublyLinkedListNode head;
        public DoublyLinkedListNode tail;

        public DoublyLinkedList()
        {
            head = null;
            tail = null;
        }
    }

    static class DoublyLinkedListNode
    {

        public int data;
        public DoublyLinkedListNode next;
        public DoublyLinkedListNode prev;

        public DoublyLinkedListNode(int nodeData)
        {
            data = nodeData;
            next = null;
            prev = null;
        }
    }


    public ReverseDoublyLinkedList()
    {
    }

    public static void printSinglyLinkedList(DoublyLinkedListNode node, String sep)
        throws IOException
    {
        do
        {
            if(node == null)
                break;
            System.out.print(node.data);
            node = node.next;
            if(node != null)
                System.out.print(sep);
        } while(true);
    }

    static DoublyLinkedListNode reverse(DoublyLinkedListNode head)
    {
        if(head == null || head.next == null)
            return head;
        DoublyLinkedListNode prev = null;
        DoublyLinkedListNode curr = head;
        DoublyLinkedListNode next = null;
        for(; curr != null; curr = next)
        {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
        }

        return prev;
    }

    public static void main(String args[])
        throws IOException
    {
        DoublyLinkedList llist = new DoublyLinkedList();
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++)
        {
            int llistCount = scanner.nextInt();
            for(int j = 0; j < llistCount; j++)
            {
                int llistItem = scanner.nextInt();
                llist.insertNode(llistItem);
            }

            DoublyLinkedListNode llist_head = reverse(llist.head);
            printSinglyLinkedList(llist_head, "->");
        }

        scanner.close();
    }

    private static final Scanner scanner;

    static 
    {
        scanner = new Scanner(System.in);
    }
}
