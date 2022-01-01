// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MarkToys.java

package com.hackerrank.pratice.interview.Sorting;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class MarkToys
{

    public MarkToys()
    {
    }

    static int maximumToys(int prices[], int k)
    {
        int count = 0;
        Arrays.sort(prices);
        int ai[] = prices;
        int j = ai.length;
        int l = 0;
        do
        {
            if(l >= j)
                break;
            int i = ai[l];
            if(i >= k)
                break;
            count++;
            k -= i;
            l++;
        } while(true);
        return count;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        int ans = maximumToys(arr, k);
        System.out.println(ans);
    }
}
