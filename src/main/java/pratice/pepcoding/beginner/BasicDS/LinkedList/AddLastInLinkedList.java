// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AddLastInLinkedList.java

package pratice.pepcoding.beginner.BasicDS.LinkedList;

import java.io.*;

public class AddLastInLinkedList
{
    public static class LinkedList
    {

        void addLast(int val)
        {
            Node temp = new Node();
            temp.data = val;
            temp.next = null;
            if(size == 0)
            {
                head = tail = temp;
            } else
            {
                tail.next = temp;
                tail = temp;
            }
            size++;
        }

        Node head;
        Node tail;
        int size;

        public LinkedList()
        {
        }
    }

    public static class Node
    {

        int data;
        Node next;

        public Node()
        {
        }
    }


    public AddLastInLinkedList()
    {
    }

    public static void testList(LinkedList list)
    {
        for(Node temp = list.head; temp != null; temp = temp.next)
            System.out.println(temp.data);

        System.out.println(list.size);
        if(list.size > 0)
            System.out.println(list.tail.data);
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LinkedList list = new LinkedList();
        for(String str = br.readLine(); !str.equals("quit"); str = br.readLine())
            if(str.startsWith("addLast"))
            {
                int val = Integer.parseInt(str.split(" ")[1]);
                list.addLast(val);
            }

        testList(list);
    }
}
