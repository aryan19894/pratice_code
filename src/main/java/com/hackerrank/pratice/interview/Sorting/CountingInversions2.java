// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CountingInversions2.java

package com.hackerrank.pratice.interview.Sorting;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class CountingInversions2
{

    public CountingInversions2()
    {
    }

    static long countInversions(int arr[])
    {
        long inversionsCount = 0L;
        int lowerArray[] = new int[arr.length];
        int higherArray[] = new int[arr.length];
        inversionsCount = countAndSort(arr, 0, arr.length - 1, lowerArray, higherArray);
        return inversionsCount;
    }

    static long countAndSort(int arr[], int low, int high, int lowerArray[], int higherArray[])
    {
        long totalCount = 0L;
        long count = 0L;
        if(low < high)
        {
            int mid = low + (high - low) / 2;
            long lowerCount = countAndSort(arr, low, mid, lowerArray, higherArray);
            long higherCount = countAndSort(arr, mid + 1, high, lowerArray, higherArray);
            totalCount += lowerCount + higherCount + countAndSortMerge(arr, low, mid, high, lowerArray, higherArray);
        }
        return totalCount;
    }

    static long countAndSortMerge(int arr[], int low, int mid, int high, int lowerArray[], int higherArray[])
    {
        long countInversions = 0L;
        for(int i = 0; i < (mid - low) + 1; i++)
            lowerArray[i] = arr[low + i];

        for(int i = 0; i < high - mid; i++)
            higherArray[i] = arr[mid + 1 + i];

        int lowIndex = 0;
        int highIndex = 0;
        int arrIndex;
        for(arrIndex = low; lowIndex < (mid - low) + 1 && highIndex < high - mid; arrIndex++)
            if(lowerArray[lowIndex] <= higherArray[highIndex])
            {
                arr[arrIndex] = lowerArray[lowIndex];
                lowIndex++;
            } else
            {
                arr[arrIndex] = higherArray[highIndex];
                highIndex++;
                countInversions += ((mid - low) + 1) - lowIndex;
            }

        while(lowIndex < (mid - low) + 1) 
        {
            arr[arrIndex] = lowerArray[lowIndex];
            lowIndex++;
            arrIndex++;
        }
        while(highIndex < high - mid) 
        {
            arr[arrIndex] = higherArray[highIndex];
            highIndex++;
            arrIndex++;
        }
        System.out.printf("CountandsortMerge inversions - %d", new Object[] {
            Long.valueOf(countInversions)
        });
        return countInversions;
    }

    public static void main(String args[])
        throws IOException
    {
        Scanner in = new Scanner(System.in);
        int d = in.nextInt();
        for(int j = 0; j < d; j++)
        {
            int n = in.nextInt();
            int arr[] = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = in.nextInt();

            long ans = countInversions(arr);
            System.out.println(ans);
        }

    }

    private static final Scanner scanner;

    static 
    {
        scanner = new Scanner(System.in);
    }
}
