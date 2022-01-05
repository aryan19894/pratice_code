// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MergeKSortedLists.java

package com.pepcoding.beginner.AdvanceDS.HashmpHeap;

import java.io.*;
import java.util.*;

public class MergeKSortedLists
{
    static class Pair
        implements Comparable
    {

        public int compareTo(Pair o)
        {
            return val - o.val;
        }

        public int compareTo(Object obj)
        {
            return compareTo((Pair)obj);
        }

        int listIdx;
        int dataIdx;
        int val;

        public Pair(int listIdx, int dataIdx, int val)
        {
            this.listIdx = listIdx;
            this.dataIdx = dataIdx;
            this.val = val;
        }
    }


    public MergeKSortedLists()
    {
    }

    public static ArrayList mergeKSortedLists(ArrayList lists)
    {
        PriorityQueue pq = new PriorityQueue();
        ArrayList rv = new ArrayList();
        for(int i = 0; i < lists.size(); i++)
            pq.add(new Pair(i, 0, ((Integer)((ArrayList)lists.get(i)).get(0)).intValue()));

        do
        {
            if(pq.isEmpty())
                break;
            Pair p = (Pair)pq.remove();
            rv.add(Integer.valueOf(p.val));
            p.dataIdx++;
            if(p.dataIdx < ((ArrayList)lists.get(p.listIdx)).size())
            {
                p.val = ((Integer)((ArrayList)lists.get(p.listIdx)).get(p.dataIdx)).intValue();
                pq.add(p);
            }
        } while(true);
        return rv;
    }

    public static void main(String args[])
        throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        ArrayList lists = new ArrayList();
        for(int i = 0; i < k; i++)
        {
            ArrayList list = new ArrayList();
            int n = Integer.parseInt(br.readLine());
            String elements[] = br.readLine().split(" ");
            for(int j = 0; j < n; j++)
                list.add(Integer.valueOf(Integer.parseInt(elements[j])));

            lists.add(list);
        }

        ArrayList mlist = mergeKSortedLists(lists);
        int val;
        for(Iterator iterator = mlist.iterator(); iterator.hasNext(); System.out.print((new StringBuilder()).append(val).append(" ").toString()))
            val = ((Integer)iterator.next()).intValue();

        System.out.println();
    }
}
