// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   UnboundedKnapsack.java

package revise.pepcoding.beginner.DynamicProg.DynamicProgAndGreedy;

import java.io.PrintStream;
import java.util.Scanner;

public class UnboundedKnapsack
{

    public UnboundedKnapsack()
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
        int dp[] = new int[cap + 1];
        for(int i = 1; i < dp.length; i++)
        {
            int max = 0x80000000;
            for(int j = 0; j < n; j++)
            {
                int wt = w[j];
                int vl = v[j];
                if(i >= wt)
                    max = Math.max(max, vl + dp[i - wt]);
            }

            if(max != 0x80000000)
                dp[i] = max;
        }

        System.out.println(dp[cap]);
    }
}
