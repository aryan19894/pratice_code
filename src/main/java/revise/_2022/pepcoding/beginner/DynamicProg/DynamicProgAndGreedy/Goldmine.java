// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Goldmine.java

package revise._2022.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class Goldmine
{

    public Goldmine()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int a[][] = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
                a[i][j] = scn.nextInt();

        }

        int dp[][] = new int[n][m];
        int max = 0x80000000;
        for(int j = m - 1; j >= 0; j--)
        {
            for(int i = n - 1; i >= 0; i--)
            {
                if(j == m - 1)
                {
                    dp[i][j] = a[i][j];
                    continue;
                }
                if(i == 0)
                {
                    dp[i][j] = a[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                    continue;
                }
                if(i == n - 1)
                {
                    dp[i][j] = a[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                    continue;
                }
                dp[i][j] = a[i][j] + Math.max(Math.max(dp[i - 1][j + 1], dp[i][j + 1]), dp[i + 1][j + 1]);
                if(j == 0)
                    max = Math.max(max, dp[i][j]);
            }

        }

        System.out.println(max);
    }
}
