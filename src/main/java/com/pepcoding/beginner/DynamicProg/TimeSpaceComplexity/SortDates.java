// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SortDates.java

package com.pepcoding.beginner.DynamicProg.TimeSpaceComplexity;

import java.io.PrintStream;
import java.util.Scanner;

public class SortDates
{

    public SortDates()
    {
    }

    public static void sortDates(String arr[])
    {
        countSort(arr, 0xf4240, 100, 32);
        countSort(arr, 10000, 100, 13);
        countSort(arr, 1, 10000, 2501);
    }

    public static void countSort(String arr[], int div, int mod, int range)
    {
        int n = arr.length;
        String ans[] = new String[n];
        int freq[] = new int[range];
        for(int i = 0; i < n; i++)
        {
            int idx = (Integer.parseInt(arr[i], 10) / div) % mod;
            freq[idx]++;
        }

        for(int i = 1; i < range; i++)
            freq[i] += freq[i - 1];

        for(int i = n - 1; i >= 0; i--)
        {
            int idx = (Integer.parseInt(arr[i], 10) / div) % mod;
            ans[freq[idx] - 1] = arr[i];
            freq[idx]--;
        }

        for(int i = 0; i < n; i++)
            arr[i] = ans[i];

    }

    public static void print(String arr[])
    {
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        String arr[] = new String[n];
        for(int i = 0; i < n; i++)
        {
            String str = scn.next();
            arr[i] = str;
        }

        sortDates(arr);
        print(arr);
    }
}
