// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ClimbStairsWithMinimumMoves.java

package com.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class ClimbStairsWithMinimumMoves
{

    public ClimbStairsWithMinimumMoves()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        Integer dp[] = new Integer[n + 1];
        dp[n] = Integer.valueOf(0);
        for(int i = n - 1; i >= 0; i--)
        {
            if(arr[i] <= 0)
                continue;
            int min = 0x7fffffff;
            for(int j = 1; j <= arr[i] && i + j < dp.length; j++)
                if(dp[i + j] != null)
                    min = Math.min(min, dp[i + j].intValue());

            if(min != 0x7fffffff)
                dp[i] = Integer.valueOf(min + 1);
        }

        System.out.println(dp[0]);
    }
}
