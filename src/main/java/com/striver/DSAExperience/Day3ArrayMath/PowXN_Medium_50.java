// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PowXN_50.java

package com.striver.DSAExperience.Day3ArrayMath;

public class PowXN_Medium_50
{
    static class Solution
    {

        public double myPow1(double x, int n)
        {
            long ln = Math.abs(n);
            double ans = 1.0D;
            for(int i = 0; (long)i < ln; i++)
                ans *= x;

            return n <= 0 ? 1.0D / ans : ans;
        }

        public double myPow2(double x, int n)
        {
            long ln = n;
            ln = ln >= 0L ? ln : -1L * ln;
            double ans = 1.0D;
            while(ln > 0L) 
                if(ln % 2L == 0L)
                {
                    x *= x;
                    ln /= 2L;
                } else
                {
                    ans *= x;
                    ln--;
                }
            return n <= 0 ? 1.0D / ans : ans;
        }

        Solution()
        {
        }
    }


    public static void main(String args[])
    {
        Solution sol = new Solution();
        double x = 2D;
        int n = 0x80000000;
        System.out.println(sol.myPow2(x, n));
    }
}
