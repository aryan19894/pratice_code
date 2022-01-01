// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TargetSumPair1.java

package com.pepcoding.beginner.DynamicProg.TimeSpaceComplexity;

import java.io.PrintStream;
import java.util.Scanner;

public class TargetSumPair1
{

    public TargetSumPair1()
    {
    }

    public static void targetSumPair(int arr[], int target)
    {
        int n = arr.length;
        arr = mergeSort(arr, 0, n - 1);
        int i = 0;
        for(int j = n - 1; i < j;)
        {
            int sum = arr[i] + arr[j];
            if(sum < target)
                i++;
            else
            if(sum > target)
            {
                j--;
            } else
            {
                System.out.println((new StringBuilder()).append(arr[i]).append(", ").append(arr[j]).toString());
                i++;
                j--;
            }
        }

    }

    private static int[] mergeSort(int arr[], int low, int high)
    {
        if(low == high)
        {
            return (new int[] {
                arr[low]
            });
        } else
        {
            int mid = (low + high) / 2;
            int l[] = mergeSort(arr, low, mid);
            int r[] = mergeSort(arr, mid + 1, high);
            return mergeTwoSorted(l, r);
        }
    }

    private static int[] mergeTwoSorted(int l[], int r[])
    {
        int n = l.length;
        int m = r.length;
        int ans[] = new int[n + m];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < l.length && j < r.length) 
            if(l[i] < r[j])
                ans[k++] = l[i++];
            else
            if(l[i] > r[j])
            {
                ans[k++] = r[j++];
            } else
            {
                ans[k++] = l[i++];
                ans[k++] = r[j++];
            }
        for(; i < n; i++)
            ans[k++] = l[i];

        for(; j < m; j++)
            ans[k++] = r[j];

        return ans;
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int target = scn.nextInt();
        targetSumPair(arr, target);
    }
}
