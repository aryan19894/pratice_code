// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PartitionAnArray.java

package pratice.pepcoding.beginner.DynamicProg.TimeSpaceComplexity;

import java.io.PrintStream;
import java.util.Scanner;

public class PartitionAnArray
{

    public PartitionAnArray()
    {
    }

    public static void partition(int arr[], int pivot)
    {
        int i = 0;
        int j = 0;
        while(i < arr.length) 
            if(arr[i] <= pivot)
            {
                swap(arr, i, j);
                i++;
                j++;
            } else
            {
                i++;
            }
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

        int pivot = scn.nextInt();
        partition(arr, pivot);
        print(arr);
    }
}
