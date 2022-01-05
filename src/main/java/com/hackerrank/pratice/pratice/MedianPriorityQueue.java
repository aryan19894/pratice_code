// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MedianPriorityQueue.java

package com.hackerrank.pratice.pratice;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MedianPriorityQueue
{

    public MedianPriorityQueue()
    {
    }

    private static double[] getMedians(int arr[])
    {
        PriorityQueue lowers = new PriorityQueue(new Comparator() {

            public int compare(Integer a, Integer b)
            {
                return -1 * a.compareTo(b);
            }

            public int compare(Object obj, Object obj1)
            {
                return compare((Integer)obj, (Integer)obj1);
            }

        }
);
        PriorityQueue highers = new PriorityQueue();
        double medians[] = new double[arr.length];
        for(int i = 0; i < arr.length; i++)
        {
            int n = arr[i];
            addNumber(n, lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }

        return medians;
    }

    private static double getMedian(PriorityQueue lowers, PriorityQueue highers)
    {
        PriorityQueue biggerHeap = lowers.size() <= highers.size() ? highers : lowers;
        PriorityQueue smallerHeap = lowers.size() <= highers.size() ? lowers : highers;
        if(biggerHeap.size() == smallerHeap.size())
            return ((double)((Integer)biggerHeap.peek()).intValue() + (double)((Integer)smallerHeap.peek()).intValue()) / 2D;
        else
            return (double)((Integer)biggerHeap.peek()).intValue();
    }

    private static void rebalance(PriorityQueue lowers, PriorityQueue highers)
    {
        PriorityQueue biggerHeap = lowers.size() <= highers.size() ? highers : lowers;
        PriorityQueue smallerHeap = lowers.size() <= highers.size() ? lowers : highers;
        if(biggerHeap.size() - smallerHeap.size() >= 2)
            smallerHeap.add(biggerHeap.poll());
    }

    private static void addNumber(int n, PriorityQueue lowers, PriorityQueue highers)
    {
        if(lowers.size() == 0 || n < ((Integer)lowers.peek()).intValue())
            lowers.add(Integer.valueOf(n));
        else
            highers.add(Integer.valueOf(n));
    }

    public static void main(String args1[])
    {
    }
}
