// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Sort012.java

package pratice.pepcoding.beginner.DynamicProg.TimeSpaceComplexity;

import java.io.PrintStream;
import java.util.Scanner;

public class Sort012
{

    public Sort012()
    {
    }

    public static void sort012(int arr[])
    {
        int i = 0;
        int j = 0;
        for(int k = arr.length - 1; i <= k;)
            if(arr[i] == 0)
            {
                swap(arr, i, j);
                i++;
                j++;
            } else
            if(arr[i] == 2)
            {
                swap(arr, i, k);
                k--;
            } else
            {
                i++;
            }

    }

    public static void swap(int arr[], int i, int j)
    {
        System.out.println((new StringBuilder()).append("Swapping index ").append(i).append(" and index ").append(j).toString());
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        sort012(arr);
        print(arr);
    }
}
