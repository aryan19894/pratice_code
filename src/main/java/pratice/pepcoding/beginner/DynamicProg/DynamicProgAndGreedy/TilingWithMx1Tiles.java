// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TilingWithMx1Tiles.java

package pratice.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class TilingWithMx1Tiles
{

    public TilingWithMx1Tiles()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int dp[] = new int[n + 1];
        for(int i = 1; i <= n; i++)
        {
            if(i < m)
            {
                dp[i] = 1;
                continue;
            }
            if(i == m)
                dp[i] = 2;
            else
                dp[i] = dp[i - 1] + dp[i - m];
        }

        System.out.println(dp[n]);
    }
}
