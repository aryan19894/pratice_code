// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ZeroOneKnapsack.java

package pratice.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class ZeroOneKnapsack
{

    public ZeroOneKnapsack()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int val[] = new int[n];
        for(int i = 0; i < n; i++)
            val[i] = scn.nextInt();

        int weight[] = new int[n];
        for(int i = 0; i < n; i++)
            weight[i] = scn.nextInt();

        int cap = scn.nextInt();
        int dp[][] = new int[n + 1][cap + 1];
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= cap; j++)
                if(weight[i - 1] <= j)
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - weight[i - 1]]);
                else
                    dp[i][j] = dp[i - 1][j];

        }

        System.out.println(dp[n][cap]);
    }
}
