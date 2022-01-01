// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   StackToQueueAdapterRemoveEfficient.java

package com.pepcoding.beginner.BasicDS.Adapter;

import java.io.*;
import java.util.Stack;

public class StackToQueueAdapterRemoveEfficient
{
    public static class StackToQueueAdapter
    {

        int size()
        {
            return mainS.size();
        }

        void add(int val)
        {
            for(; !mainS.isEmpty(); helperS.push(mainS.pop()));
            mainS.push(Integer.valueOf(val));
            for(; !helperS.isEmpty(); mainS.push(helperS.pop()));
        }

        int remove()
        {
            if(size() == 0)
            {
                System.out.println("Queue underflow");
                return -1;
            } else
            {
                return ((Integer)mainS.pop()).intValue();
            }
        }

        int peek()
        {
            if(size() == 0)
            {
                System.out.println("Queue underflow");
                return -1;
            } else
            {
                return ((Integer)mainS.peek()).intValue();
            }
        }

        Stack mainS;
        Stack helperS;

        public StackToQueueAdapter()
        {
            mainS = new Stack();
            helperS = new Stack();
        }
    }


    public StackToQueueAdapterRemoveEfficient()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StackToQueueAdapter qu = new StackToQueueAdapter();
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
