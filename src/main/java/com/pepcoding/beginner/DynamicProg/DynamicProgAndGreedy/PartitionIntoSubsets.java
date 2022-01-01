// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PartitionIntoSubsets.java

package com.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class PartitionIntoSubsets
{

    public PartitionIntoSubsets()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        long dp[][] = new long[k + 1][n + 1];
        if(n == 0 || k == 0 || n < k)
        {
            System.out.println(0);
            return;
        }
        for(int i = 1; i <= k; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(j < i)
                {
                    dp[i][j] = 0L;
                    continue;
                }
                if(j == i)
                    dp[i][j] = 1L;
                else
                    dp[i][j] = (long)i * dp[i][j - 1] + dp[i - 1][j - 1];
            }

        }

        System.out.println(dp[k][n]);
    }
}
