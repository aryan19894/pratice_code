// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   LastIndex.java

package revise._2022.pepcoding.beginner.RecursionAndBacktracking.RecursionInArrays;

import java.io.PrintStream;
import java.util.Scanner;

public class LastIndex
{

    public LastIndex()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int x = scn.nextInt();
        System.out.println(lastIndex(a, 0, x));
    }

    public static int lastIndex(int arr[], int idx, int x)
    {
        if(idx == arr.length)
            return -1;
        int pval = lastIndex(arr, idx + 1, x);
        if(pval == -1 && arr[idx] == x)
            return idx;
        else
            return pval;
    }
}
