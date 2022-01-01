// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day15_LinkedList.java

package com.hackerrank.pratice.Day30OfCode;

import com.common.SingleListNode;
import java.io.PrintStream;
import java.util.Scanner;

public class Day15_LinkedList
{

    public Day15_LinkedList()
    {
    }

    public static SingleListNode insert(SingleListNode head, int data)
    {
        SingleListNode newNode = new SingleListNode(data);
        if(head == null)
        {
            head = newNode;
            return head;
        }
        SingleListNode start;
        for(start = head; start.next != null; start = start.next);
        start.next = newNode;
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
        for(int N = sc.nextInt(); N-- > 0;)
        {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }

        display(head);
        sc.close();
    }
}
