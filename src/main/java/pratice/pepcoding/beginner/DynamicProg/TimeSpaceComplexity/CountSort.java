// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CountSort.java

package pratice.pepcoding.beginner.DynamicProg.TimeSpaceComplexity;

import java.io.PrintStream;
import java.util.Scanner;

public class CountSort
{

    public CountSort()
    {
    }

    public static void countSort(int arr[], int min, int max)
    {
        int fn = (max - min) + 1;
        int n = arr.length;
        int freq[] = new int[fn];
        int ans[] = new int[n];
        for(int i = 0; i < n; i++)
            freq[arr[i] - min]++;

        for(int i = 1; i < fn; i++)
            freq[i] += freq[i - 1];

        for(int i = n - 1; i >= 0; i--)
        {
            int fi = arr[i] - min;
            ans[freq[fi] - 1] = arr[i];
            freq[fi]--;
        }

        for(int i = 0; i < n; i++)
            arr[i] = ans[i];

    }

    public static void print(int arr[])
    {
        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        int max = 0x80000000;
        int min = 0x7fffffff;
        for(int i = 0; i < n; i++)
        {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        countSort(arr, min, max);
        print(arr);
    }
}
