// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ZeroOneKnapsack.java

package revise.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

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
        int v[] = new int[n];
        for(int i = 0; i < n; i++)
            v[i] = scn.nextInt();

        int w[] = new int[n];
        for(int i = 0; i < n; i++)
            w[i] = scn.nextInt();

        int cap = scn.nextInt();
        int dp[][] = new int[n + 1][cap + 1];
        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 1; j < dp[0].length; j++)
            {
                int wt = w[i - 1];
                int vl = v[i - 1];
                if(j < wt)
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = Math.max(vl + dp[i - 1][j - wt], dp[i - 1][j]);
            }

        }

        System.out.println(dp[n][cap]);
    }
}
