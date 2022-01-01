// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BuyAndSellStocksKTransactionsAllowed.java

package com.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class BuyAndSellStocksKTransactionsAllowed
{

    public BuyAndSellStocksKTransactionsAllowed()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int k = scn.nextInt();
        int dp[][] = new int[k + 1][n];
        for(int i = 1; i <= k; i++)
        {
            for(int j = 1; j < n; j++)
            {
                int max = 0x80000000;
                for(int x = j - 1; x >= 0; x--)
                    max = Math.max(max, (a[j] - a[x]) + dp[i - 1][x]);

                dp[i][j] = Math.max(max, dp[i][j - 1]);
            }

        }

        System.out.println(dp[k][n - 1]);
    }
}
