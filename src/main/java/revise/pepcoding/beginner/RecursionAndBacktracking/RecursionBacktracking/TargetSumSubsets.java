// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TargetSumSubsets.java

package revise.pepcoding.beginner.RecursionAndBacktracking.RecursionBacktracking;

import java.io.PrintStream;
import java.util.Scanner;

public class TargetSumSubsets
{

    public TargetSumSubsets()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int tar = scn.nextInt();
        printTargetSumSubsets(a, 0, "", 0, tar);
    }

    public static void printTargetSumSubsets(int arr[], int idx, String set, int sos, int tar)
    {
        if(idx == arr.length)
        {
            if(sos == tar)
                System.out.println((new StringBuilder()).append(set).append(".").toString());
            return;
        } else
        {
            printTargetSumSubsets(arr, idx + 1, (new StringBuilder()).append(set).append(arr[idx]).append(", ").toString(), sos + arr[idx], tar);
            printTargetSumSubsets(arr, idx + 1, set, sos, tar);
            return;
        }
    }
}
