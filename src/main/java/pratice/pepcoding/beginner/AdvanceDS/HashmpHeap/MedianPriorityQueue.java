// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MedianPriorityQueue.java

package pratice.pepcoding.beginner.AdvanceDS.HashmpHeap;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPriorityQueue
{

    public MedianPriorityQueue()
    {
        left = new PriorityQueue(Collections.reverseOrder());
        right = new PriorityQueue();
    }

    public void add(int val)
    {
        if(!right.isEmpty() && val > ((Integer)right.peek()).intValue())
            right.add(Integer.valueOf(val));
        else
            left.add(Integer.valueOf(val));
        if(left.size() - right.size() == 2)
            right.add(left.remove());
        else
        if(right.size() - left.size() == 2)
            left.add(right.remove());
    }

    public int remove()
    {
        if(size() == 0)
        {
            System.out.println("Underflow");
            return -1;
        } else
        {
            return left.size() < right.size() ? ((Integer)right.remove()).intValue() : ((Integer)left.remove()).intValue();
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
            return left.size() < right.size() ? ((Integer)right.peek()).intValue() : ((Integer)left.peek()).intValue();
        }
    }

    public int size()
    {
        return left.size() + right.size();
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MedianPriorityQueue qu = new MedianPriorityQueue();
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

    PriorityQueue left;
    PriorityQueue right;
}
