// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RadixSort.java

package pratice.pepcoding.beginner.DynamicProg.TimeSpaceComplexity;

import java.io.PrintStream;
import java.util.Scanner;

public class RadixSort
{

    public RadixSort()
    {
    }

    public static void radixSort(int arr[])
    {
        int max = 0x80000000;
        int ai[] = arr;
        int i = ai.length;
        for(int j = 0; j < i; j++)
        {
            int val = ai[j];
            max = Math.max(max, val);
        }

        for(int exp = 1; exp <= max; exp *= 10)
            countSort(arr, exp);

    }

    public static void countSort(int arr[], int exp)
    {
        int n = arr.length;
        int freq[] = new int[10];
        int ans[] = new int[n];
        for(int i = 0; i < n; i++)
            freq[(arr[i] / exp) % 10]++;

        for(int i = 1; i < freq.length; i++)
            freq[i] += freq[i - 1];

        for(int i = n - 1; i >= 0; i--)
        {
            int dig = (arr[i] / exp) % 10;
            ans[freq[dig] - 1] = arr[i];
            freq[dig]--;
        }

        for(int i = 0; i < n; i++)
            arr[i] = ans[i];

        System.out.print((new StringBuilder()).append("After sorting on ").append(exp).append(" place -> ").toString());
        print(arr);
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

        radixSort(arr);
        print(arr);
    }
}
