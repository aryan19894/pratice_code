// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CommonChild2.java

package com.hackerrank.pratice.interview.String;

import java.io.PrintStream;
import java.util.Scanner;

public class CommonChild2
{

    public CommonChild2()
    {
    }

    static int commonChild(String s1, String s2)
    {
        int n = s1.length();
        int dp[][] = new int[n + 1][n + 1];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                if(s1.charAt(i) == s2.charAt(j))
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                else
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);

        }

        return dp[n][n];
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(commonChild(a, b));
    }
}
