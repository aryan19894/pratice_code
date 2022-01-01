// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   WritePriorityQueueUsingHeap.java

package com.pepcoding.beginner.AdvanceDS.HashmpHeap;

import java.io.*;
import java.util.ArrayList;

public class WritePriorityQueueUsingHeap
{
    public static class PriorityQueue
    {

        public void add(int val)
        {
            data.add(Integer.valueOf(val));
            upheapify(size() - 1);
        }

        private void upheapify(int ci)
        {
            if(ci == 0)
                return;
            int pi = (ci - 2) / 2;
            if(((Integer)data.get(pi)).intValue() > ((Integer)data.get(ci)).intValue())
            {
                swap(ci, pi);
                upheapify(pi);
            }
        }

        private void swap(int ci, int pi)
        {
            int temp = ((Integer)data.get(pi)).intValue();
            data.set(pi, data.get(ci));
            data.set(ci, Integer.valueOf(temp));
        }

        public int remove()
        {
            if(size() == 0)
            {
                System.out.println("Underflow");
                return -1;
            } else
            {
                swap(0, size() - 1);
                int val = ((Integer)data.remove(size() - 1)).intValue();
                downheapify(0);
                return val;
            }
        }

        private void downheapify(int pi)
        {
            int min = pi;
            int li = pi * 2 + 1;
            if(li < size() && ((Integer)data.get(li)).intValue() < ((Integer)data.get(min)).intValue())
                min = li;
            int ri = pi * 2 + 2;
            if(ri < size() && ((Integer)data.get(ri)).intValue() < ((Integer)data.get(min)).intValue())
                min = ri;
            if(min != pi)
            {
                swap(pi, min);
                downheapify(min);
            }
        }

        public int peek()
        {
            if(size() == 0)
            {
                System.out.println("Underflow");
                return -1;
            } else
            {
                return ((Integer)data.get(0)).intValue();
            }
        }

        public int size()
        {
            return data.size();
        }

        ArrayList data;

        public PriorityQueue()
        {
            data = new ArrayList();
        }
    }


    public WritePriorityQueueUsingHeap()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue qu = new PriorityQueue();
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
