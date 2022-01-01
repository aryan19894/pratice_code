// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PaintHouse.java

package com.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class PaintHouse
{

    public PaintHouse()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[][] = new int[n][3];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < 3; j++)
                a[i][j] = scn.nextInt();

        }

        int dp[][] = new int[n][3];
        dp[0][0] = a[0][0];
        dp[0][1] = a[0][1];
        dp[0][2] = a[0][2];
        for(int i = 1; i < n; i++)
        {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + a[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + a[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + a[i][2];
        }

        System.out.println(Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2])));
    }
}
