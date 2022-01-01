// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BuyAndSellStocksWithTransactionFeeInfiniteTransactionsAllowed.java

package com.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class BuyAndSellStocksWithTransactionFeeInfiniteTransactionsAllowed
{

    public BuyAndSellStocksWithTransactionFeeInfiniteTransactionsAllowed()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int fee = scn.nextInt();
        int obuy = -a[0];
        int osell = 0;
        for(int i = 1; i < n; i++)
        {
            obuy = Math.max(obuy, osell - a[i]);
            osell = Math.max(osell, (obuy + a[i]) - fee);
        }

        System.out.println(osell);
    }
}
