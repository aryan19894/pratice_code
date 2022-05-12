// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MaxArraySum.java

package pratice.hackerrank.pratice.interview.DP;

import java.io.PrintStream;
import java.util.Scanner;

public class MaxArraySum
{

    public MaxArraySum()
    {
    }

    public static int maxSubsetSum(int a[])
    {
        int inc = a[0];
        int exc = 0;
        for(int i = 1; i < a.length; i++)
        {
            int temp = exc;
            exc = Math.max(inc, exc);
            inc = temp + a[i];
        }

        return Math.max(inc, exc);
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = in.nextInt();

        int ans = maxSubsetSum(a);
        System.out.println(ans);
    }
}
