// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PivotInSortedAndRotatedArray.java

package pratice.pepcoding.beginner.DynamicProg.TimeSpaceComplexity;

import java.io.PrintStream;
import java.util.Scanner;

public class PivotInSortedAndRotatedArray
{

    public PivotInSortedAndRotatedArray()
    {
    }

    public static int findPivot(int arr[])
    {
        int l = 0;
        int h;
        for(h = arr.length - 1; l <= h;)
        {
            int mid = (l + h) / 2;
            if(arr[mid] < arr[h])
                h = mid;
            else
                l = mid + 1;
        }

        return arr[h];
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int pivot = findPivot(arr);
        System.out.println(pivot);
    }
}
