// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TargetSumSubsetsDP.java

package revise.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class TargetSumSubsetsDP
{

    public TargetSumSubsetsDP()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int tar = scn.nextInt();
        boolean dp[][] = new boolean[n + 1][tar + 1];
        dp[0][0] = true;
        for(int i = 1; i < dp.length; i++)
        {
            for(int j = 0; j < dp[0].length; j++)
                if(j < a[i - 1])
                    dp[i][j] = dp[i - 1][j];
                else
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - a[i - 1]];

        }

        System.out.println(dp[n][tar]);
    }
}
