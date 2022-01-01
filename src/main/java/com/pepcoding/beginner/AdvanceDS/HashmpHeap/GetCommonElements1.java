// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetCommonElements1.java

package com.pepcoding.beginner.AdvanceDS.HashmpHeap;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Scanner;

public class GetCommonElements1
{

    public GetCommonElements1()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int a1[] = new int[n1];
        for(int i = 0; i < n1; i++)
            a1[i] = scn.nextInt();

        int n2 = scn.nextInt();
        int a2[] = new int[n2];
        for(int i = 0; i < n2; i++)
            a2[i] = scn.nextInt();

        HashMap mp = new HashMap();
        for(int i = 0; i < n1; i++)
        {
            mp.putIfAbsent(Integer.valueOf(a1[i]), Integer.valueOf(0));
            mp.put(Integer.valueOf(a1[i]), Integer.valueOf(((Integer)mp.get(Integer.valueOf(a1[i]))).intValue() + 1));
        }

        for(int i = 0; i < n2; i++)
            if(mp.containsKey(Integer.valueOf(a2[i])))
            {
                mp.remove(Integer.valueOf(a2[i]));
                System.out.println(a2[i]);
            }

    }
}
