// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CountEncodings.java

package com.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class CountEncodings
{

    public CountEncodings()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        char str[] = scn.nextLine().toCharArray();
        int n = str.length;
        int dp[] = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++)
        {
            int comb = Integer.parseInt((new StringBuilder()).append("").append(str[i - 1]).append(str[i]).toString());
            if(str[i - 1] == '0' && str[i] == '0')
            {
                dp[i] = 0;
                continue;
            }
            if(str[i - 1] == '0' && str[i] != '0')
            {
                dp[i] = dp[i - 1];
                continue;
            }
            if(str[i - 1] != '0' && str[i] == '0')
            {
                if(comb > 26)
                    continue;
                if(i - 2 >= 0)
                    dp[i] += dp[i - 2];
                else
                    dp[i]++;
                continue;
            }
            if(str[i - 1] == '0' || str[i] == '0')
                continue;
            dp[i] = dp[i - 1];
            if(comb > 26)
                continue;
            if(i - 2 >= 0)
                dp[i] += dp[i - 2];
            else
                dp[i]++;
        }

        System.out.println(dp[n - 1]);
    }
}
