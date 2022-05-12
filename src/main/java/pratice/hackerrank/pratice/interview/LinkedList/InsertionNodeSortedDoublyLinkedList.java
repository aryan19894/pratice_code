// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   InsertionNodeSortedDoublyLinkedList.java

package pratice.hackerrank.pratice.interview.LinkedList;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class InsertionNodeSortedDoublyLinkedList
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


    public InsertionNodeSortedDoublyLinkedList()
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

    static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode head, int data)
    {
        DoublyLinkedListNode newNode = new DoublyLinkedListNode(data);
        if(head == null)
            return newNode;
        if(data < head.data)
        {
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }
        DoublyLinkedListNode n1 = null;
        DoublyLinkedListNode n2;
        for(n2 = head; n2 != null && n2.data < data; n2 = n2.next)
            n1 = n2;

        if(n2 == null)
        {
            n1.next = newNode;
            newNode.prev = n1;
        } else
        {
            n1.next = newNode;
            n2.prev = newNode;
            newNode.prev = n1;
            newNode.next = n2;
        }
        return head;
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

            int data = scanner.nextInt();
            DoublyLinkedListNode llist_head = sortedInsert(llist.head, data);
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
