// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MergeSort.java

package pratice.pepcoding.beginner.DynamicProg.TimeSpaceComplexity;

import java.io.PrintStream;
import java.util.Scanner;

public class MergeSort
{

    public MergeSort()
    {
    }

    public static int[] mergeSort(int arr[], int lo, int hi)
    {
        if(lo == hi)
        {
            return (new int[] {
                arr[lo]
            });
        } else
        {
            int mid = (lo + hi) / 2;
            int left[] = mergeSort(arr, lo, mid);
            int right[] = mergeSort(arr, mid + 1, hi);
            return mergeTwoSortedArrays(left, right);
        }
    }

    public static int[] mergeTwoSortedArrays(int a[], int b[])
    {
        System.out.println("Merging these two arrays ");
        System.out.print("left array -> ");
        print(a);
        System.out.print("right array -> ");
        print(b);
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

        int sa[] = mergeSort(arr, 0, arr.length - 1);
        System.out.print("Sorted Array -> ");
        print(sa);
    }
}
