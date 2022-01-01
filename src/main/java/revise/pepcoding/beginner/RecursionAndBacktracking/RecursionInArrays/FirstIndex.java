// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   FirstIndex.java

package revise.pepcoding.beginner.RecursionAndBacktracking.RecursionInArrays;

import java.io.PrintStream;
import java.util.Scanner;

public class FirstIndex
{

    public FirstIndex()
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
        System.out.println(firstIndex(a, 0, x));
    }

    public static int firstIndex(int arr[], int idx, int x)
    {
        if(idx == arr.length)
            return -1;
        if(arr[idx] == x)
            return idx;
        else
            return firstIndex(arr, idx + 1, x);
    }
}
