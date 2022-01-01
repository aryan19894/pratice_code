// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LongestConsecutiveSequenceOfElements.java

package com.pepcoding.beginner.AdvanceDS.HashmpHeap;

import java.io.PrintStream;
import java.util.*;

public class LongestConsecutiveSequenceOfElements
{

    public LongestConsecutiveSequenceOfElements()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        findLongestConsecutiveSequence(a);
    }

    private static void findLongestConsecutiveSequence(int arr[])
    {
        HashMap map = new HashMap();
        int ai[] = arr;
        int key = ai.length;
        for(int j = 0; j < key; j++)
        {
            int a = ai[j];
            map.put(Integer.valueOf(a), Boolean.valueOf(true));
        }

        Iterator iterator = map.keySet().iterator();
        do
        {
            if(!iterator.hasNext())
                break;
            key = ((Integer)iterator.next()).intValue();
            if(map.containsKey(Integer.valueOf(key - 1)))
                map.put(Integer.valueOf(key), Boolean.valueOf(false));
        } while(true);
        int maxlen = 0;
        int start = 0;
        int ai1[] = arr;
        int k = ai1.length;
        for(int l = 0; l < k; l++)
        {
            int a = ai1[l];
            if(!((Boolean)map.get(Integer.valueOf(a))).booleanValue())
                continue;
            int len;
            for(len = 1; map.containsKey(Integer.valueOf(a + len)); len++);
            if(maxlen < len)
            {
                maxlen = len;
                start = a;
            }
        }

        for(int i = 0; i < maxlen; i++)
            System.out.println(start + i);

    }
}
