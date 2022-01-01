// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day24_MoreLinkedLists.java

package com.hackerrank.pratice.Day30OfCode;

import com.common.SingleListNode;
import java.io.PrintStream;
import java.util.Scanner;

public class Day24_MoreLinkedLists
{

    public Day24_MoreLinkedLists()
    {
    }

    public static SingleListNode removeDuplicates(SingleListNode head)
    {
        for(SingleListNode curr = head; curr != null; curr = curr.next)
        {
            SingleListNode temp;
            for(temp = curr; temp != null && temp.data == curr.data; temp = temp.next);
            curr.next = temp;
        }

        return head;
    }

    public static SingleListNode insert(SingleListNode head, int data)
    {
        SingleListNode p = new SingleListNode(data);
        if(head == null)
            head = p;
        else
        if(head.next == null)
        {
            head.next = p;
        } else
        {
            SingleListNode start;
            for(start = head; start.next != null; start = start.next);
            start.next = p;
        }
        return head;
    }

    public static void display(SingleListNode head)
    {
        for(SingleListNode start = head; start != null; start = start.next)
            System.out.print((new StringBuilder()).append(start.data).append(" ").toString());

    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        SingleListNode head = null;
        for(int T = sc.nextInt(); T-- > 0;)
        {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }

        head = removeDuplicates(head);
        display(head);
    }
}
