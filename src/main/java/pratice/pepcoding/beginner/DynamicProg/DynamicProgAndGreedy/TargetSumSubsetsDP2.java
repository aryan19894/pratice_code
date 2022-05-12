// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TargetSumSubsetsDP2.java

package pratice.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class TargetSumSubsetsDP2
{

    public TargetSumSubsetsDP2()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int tar = scn.nextInt();
        boolean dp[][] = new boolean[n + 1][tar + 1];
        for(int i = 0; i <= n; i++)
        {
            for(int j = 0; j <= tar; j++)
            {
                if(i == 0 && j == 0)
                {
                    dp[i][j] = true;
                    continue;
                }
                if(i == 0)
                {
                    dp[i][j] = false;
                    continue;
                }
                if(j == 0)
                {
                    dp[i][j] = true;
                    continue;
                }
                if(dp[i - 1][j])
                {
                    dp[i][j] = true;
                    continue;
                }
                int val = arr[i - 1];
                if(j >= val && dp[i - 1][j - val])
                    dp[i][j] = true;
            }

        }

        System.out.println(dp[n][tar]);
    }
}
