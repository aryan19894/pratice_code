// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MinCostInMazeTraversal.java

package revise._2022.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class MinCostInMazeTraversal
{

    public MinCostInMazeTraversal()
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
        for(int i = n - 1; i >= 0; i--)
        {
            for(int j = m - 1; j >= 0; j--)
            {
                if(i == n - 1 && j == m - 1)
                {
                    dp[i][j] = a[i][j];
                    continue;
                }
                if(i == n - 1)
                {
                    dp[i][j] = a[i][j] + dp[i][j + 1];
                    continue;
                }
                if(j == m - 1)
                    dp[i][j] = a[i][j] + dp[i + 1][j];
                else
                    dp[i][j] = a[i][j] + Math.min(dp[i + 1][j], dp[i][j + 1]);
            }

        }

        System.out.println(dp[0][0]);
    }
}
