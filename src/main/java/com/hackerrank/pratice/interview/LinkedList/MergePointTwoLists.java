// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MergePointTwoLists.java

package com.hackerrank.pratice.interview.LinkedList;

import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;

public class MergePointTwoLists
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


    public MergePointTwoLists()
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

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2)
    {
        HashSet set = new HashSet();
        for(; head1 != null; head1 = head1.next)
            set.add(head1);

        for(; head2 != null; head2 = head2.next)
            if(set.contains(head2))
                return head2.data;

        return -1;
    }

    public static void main(String args[])
        throws IOException
    {
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++)
        {
            int index = scanner.nextInt();
            SinglyLinkedList llist1 = new SinglyLinkedList();
            int llistCount1 = scanner.nextInt();
            for(int j = 0; j < llistCount1; j++)
            {
                int llistItem = scanner.nextInt();
                llist1.insertNode(llistItem);
            }

            SinglyLinkedList llist2 = new SinglyLinkedList();
            int llistCount2 = scanner.nextInt();
            for(int j = 0; j < llistCount2; j++)
            {
                int llistItem = scanner.nextInt();
                llist2.insertNode(llistItem);
            }

            SinglyLinkedListNode ptr1 = llist1.head;
            SinglyLinkedListNode ptr2 = llist2.head;
            for(int j = 0; j < llistCount1; j++)
                if(j < index)
                    ptr1 = ptr1.next;

            for(int j = 0; j < llistCount2; j++)
                if(j != llistCount2 - 1)
                    ptr2 = ptr2.next;

            ptr2.next = ptr1;
            int result = findMergeNode(llist1.head, llist2.head);
            System.out.println(result);
        }

    }

    private static final Scanner scanner;

    static 
    {
        scanner = new Scanner(System.in);
    }
}
