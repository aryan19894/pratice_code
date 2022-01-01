// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LinkedListToQueueAdapter.java

package com.pepcoding.beginner.BasicDS.Adapter;

import java.io.*;
import java.util.LinkedList;

public class LinkedListToQueueAdapter
{
    public static class LLToQueueAdapter
    {

        int size()
        {
            return list.size();
        }

        void add(int val)
        {
            list.addLast(Integer.valueOf(val));
        }

        int remove()
        {
            if(list.isEmpty())
            {
                System.out.println("Stack underflow");
                return -1;
            } else
            {
                return ((Integer)list.removeFirst()).intValue();
            }
        }

        int peek()
        {
            if(list.isEmpty())
            {
                System.out.println("Stack underflow");
                return -1;
            } else
            {
                return ((Integer)list.getFirst()).intValue();
            }
        }

        LinkedList list;

        public LLToQueueAdapter()
        {
            list = new LinkedList();
        }
    }


    public LinkedListToQueueAdapter()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        LLToQueueAdapter qu = new LLToQueueAdapter();
        for(String str = br.readLine(); !str.equals("quit"); str = br.readLine())
        {
            if(str.startsWith("add"))
            {
                int val = Integer.parseInt(str.split(" ")[1]);
                qu.add(val);
                continue;
            }
            if(str.startsWith("remove"))
            {
                int val = qu.remove();
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("peek"))
            {
                int val = qu.peek();
                if(val != -1)
                    System.out.println(val);
                continue;
            }
            if(str.startsWith("size"))
                System.out.println(qu.size());
        }

    }
}
