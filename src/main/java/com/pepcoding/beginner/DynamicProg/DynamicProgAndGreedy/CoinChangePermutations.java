// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CoinChangePermutations.java

package com.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class CoinChangePermutations
{

    public CoinChangePermutations()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int amt = scn.nextInt();
        int dp[] = new int[amt + 1];
        dp[0] = 1;
        for(int i = 1; i <= amt; i++)
        {
            for(int j = 0; j < n; j++)
                if(i >= arr[j])
                    dp[i] += dp[i - arr[j]];

        }

        System.out.println(dp[amt]);
    }
}
