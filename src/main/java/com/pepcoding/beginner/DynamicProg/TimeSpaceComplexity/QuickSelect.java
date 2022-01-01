// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   QuickSelect.java

package com.pepcoding.beginner.DynamicProg.TimeSpaceComplexity;

import java.io.PrintStream;
import java.util.Scanner;

public class QuickSelect
{

    public QuickSelect()
    {
    }

    public static int quickSelect(int arr[], int lo, int hi, int k)
    {
        int pi = partition(arr, arr[hi], lo, hi);
        if(pi < k)
            return quickSelect(arr, pi + 1, hi, k);
        if(pi > k)
            return quickSelect(arr, lo, pi - 1, k);
        else
            return arr[pi];
    }

    public static int partition(int arr[], int pivot, int lo, int hi)
    {
        System.out.println((new StringBuilder()).append("pivot -> ").append(pivot).toString());
        int i = lo;
        int j = lo;
        while(i <= hi) 
            if(arr[i] <= pivot)
            {
                swap(arr, i, j);
                i++;
                j++;
            } else
            {
                i++;
            }
        System.out.println((new StringBuilder()).append("pivot index -> ").append(j - 1).toString());
        return j - 1;
    }

    public static void swap(int arr[], int i, int j)
    {
        System.out.println((new StringBuilder()).append("Swapping ").append(arr[i]).append(" and ").append(arr[j]).toString());
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
            System.out.print((new StringBuilder()).append(arr[i]).append(" ").toString());

        System.out.println();
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int k = scn.nextInt();
        System.out.println(quickSelect(arr, 0, arr.length - 1, k - 1));
    }
}
