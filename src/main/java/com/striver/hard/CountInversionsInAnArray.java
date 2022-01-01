// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CountInversionsInAnArray.java

package com.striver.hard;

import java.io.PrintStream;

public class CountInversionsInAnArray
{

    public CountInversionsInAnArray()
    {
    }

    static int getInvCount1(int arr[])
    {
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++)
        {
            for(int j = i + 1; j < n; j++)
                if(arr[i] > arr[j])
                    count++;

        }

        return count;
    }

    static int getInvCount2(int arr[])
    {
        int n = arr.length;
        return mergeSort(arr, new int[n], 0, n - 1);
    }

    private static int mergeSort(int arr[], int temp[], int left, int right)
    {
        int count = 0;
        if(right > left)
        {
            int mid = (left + right) / 2;
            count += mergeSort(arr, temp, left, mid);
            count += mergeSort(arr, temp, mid + 1, right);
            count += mergeSortedArray(arr, temp, left, mid + 1, right);
        }
        return count;
    }

    private static int mergeSortedArray(int arr[], int temp[], int left, int mid, int right)
    {
        int count = 0;
        int i = left;
        int j = mid;
        int k = left;
        while(i <= mid - 1 && j <= right) 
            if(arr[i] <= arr[j])
            {
                temp[k++] = arr[i++];
            } else
            {
                temp[k++] = arr[j++];
                count += mid - i;
            }
        while(i <= mid - 1) 
            temp[k++] = arr[i++];
        while(j <= right) 
            temp[k++] = arr[j++];
        for(i = left; i <= right; i++)
            arr[i] = temp[i];

        return count;
    }

    public static void main(String args[])
    {
        int arr[] = {
            5, 3, 2, 4, 1
        };
        int ans = getInvCount2(arr);
        System.out.println(ans);
    }
}
