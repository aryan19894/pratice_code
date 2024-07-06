// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CoinChangeCombination.java

package revise._2022.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class CoinChangeCombination
{

    public CoinChangeCombination()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int amt = scn.nextInt();
        int dp[] = new int[amt + 1];
        dp[0] = 1;
        for(int i = 0; i < n; i++)
        {
            for(int j = a[i]; j < dp.length; j++)
                dp[j] += dp[j - a[i]];

        }

        System.out.println(dp[dp.length - 1]);
    }
}
