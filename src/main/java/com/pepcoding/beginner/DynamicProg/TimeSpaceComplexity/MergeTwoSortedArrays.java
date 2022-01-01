// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MergeTwoSortedArrays.java

package com.pepcoding.beginner.DynamicProg.TimeSpaceComplexity;

import java.io.PrintStream;
import java.util.Scanner;

public class MergeTwoSortedArrays
{

    public MergeTwoSortedArrays()
    {
    }

    public static int[] mergeTwoSortedArrays(int a[], int b[])
    {
        int n = a.length;
        int m = b.length;
        int c[] = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < n && j < m) 
            if(a[i] < b[j])
            {
                c[k++] = a[i];
                i++;
            } else
            if(a[i] > b[j])
            {
                c[k++] = b[j];
                j++;
            } else
            {
                c[k++] = a[i];
                i++;
                c[k++] = b[j];
                j++;
            }
        for(; i < n; i++)
            c[k++] = a[i];

        for(; j < m; j++)
            c[k++] = b[j];

        return c;
    }

    public static void print(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int m = scn.nextInt();
        int b[] = new int[m];
        for(int i = 0; i < m; i++)
            b[i] = scn.nextInt();

        int mergedArray[] = mergeTwoSortedArrays(a, b);
        print(mergedArray);
    }
}
