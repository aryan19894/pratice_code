// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   InsertionNodeLinkedList.java

package pratice.hackerrank.pratice.interview.LinkedList;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class InsertionNodeLinkedList
{
    static class SinglyLinkedList
    {

        public void insertNode(int nodeData)
        {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);
            if(head == null)
                head = node;
            else
                tail.next = node;
            tail = node;
        }

        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList()
        {
            head = null;
            tail = null;
        }
    }

    static class SinglyLinkedListNode
    {

        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData)
        {
            data = nodeData;
            next = null;
        }
    }


    public InsertionNodeLinkedList()
    {
    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node, String sep)
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

    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position)
    {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if(position == 0)
        {
            newNode.next = head;
            return newNode;
        }
        SinglyLinkedListNode n = head;
        for(int i = 0; i < position - 1; i++)
            n = n.next;

        newNode.next = n.next;
        n.next = newNode;
        return head;
    }

    public static void main(String args[])
        throws IOException
    {
        SinglyLinkedList llist = new SinglyLinkedList();
        int llistCount = scanner.nextInt();
        for(int i = 0; i < llistCount; i++)
        {
            int llistItem = scanner.nextInt();
            llist.insertNode(llistItem);
        }

        int data = scanner.nextInt();
        int position = scanner.nextInt();
        SinglyLinkedListNode llist_head = insertNodeAtPosition(llist.head, data, position);
        printSinglyLinkedList(llist_head, "->");
        scanner.close();
    }

    private static final Scanner scanner;

    static 
    {
        scanner = new Scanner(System.in);
    }
}
