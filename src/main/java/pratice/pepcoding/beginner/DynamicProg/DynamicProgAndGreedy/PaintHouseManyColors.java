// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PaintHouseManyColors.java

package pratice.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class PaintHouseManyColors
{

    public PaintHouseManyColors()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();
        int a[][] = new int[n][k];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < k; j++)
                a[i][j] = scn.nextInt();

        }

        int dp[][] = new int[n][k];
        for(int j = 0; j < k; j++)
            dp[0][j] = a[0][j];

        int ans = 0x7fffffff;
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < k; j++)
            {
                int min = 0x7fffffff;
                for(int m = 0; m < k; m++)
                    if(j != m)
                        min = Math.min(min, dp[i - 1][m]);

                dp[i][j] = min + a[i][j];
                if(i == n - 1)
                    ans = Math.min(ans, dp[i][j]);
            }

        }

        System.out.println(ans);
    }
}
