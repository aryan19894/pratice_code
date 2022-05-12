// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CountingInversions3.java

package pratice.hackerrank.pratice.interview.Sorting;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class CountingInversions3
{

    public CountingInversions3()
    {
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

            long ans = mergeSortAndCount(arr, 0, arr.length - 1);
            System.out.println(ans);
        }

    }

    private static long mergeSortAndCount(int arr[], int l, int r)
    {
        long count = 0L;
        if(l < r)
        {
            int m = (l + r) / 2;
            count += mergeSortAndCount(arr, l, m);
            count += mergeSortAndCount(arr, m + 1, r);
            count += mergeAndCount(arr, l, m, r);
        }
        return count;
    }

    private static long mergeAndCount(int arr[], int l, int m, int r)
    {
        int left[] = Arrays.copyOfRange(arr, l, m + 1);
        int right[] = Arrays.copyOfRange(arr, m + 1, r + 1);
        int i = 0;
        int j = 0;
        int k = l;
        long swaps = 0L;
        while(i < left.length && j < right.length) 
            if(left[i] <= right[j])
            {
                arr[k++] = left[i++];
            } else
            {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        while(i < left.length) 
            arr[k++] = left[i++];
        while(j < right.length) 
            arr[k++] = right[j++];
        return swaps;
    }

    private static final Scanner scanner;

    static 
    {
        scanner = new Scanner(System.in);
    }
}
