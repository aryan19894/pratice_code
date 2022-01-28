// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PowXN_50.java

package com.striver.DSAExperience.T1Array;

public class PowXN_Medium_50 {
    static class Solution {

        public double myPow1(double x, int n) {
            long ln = Math.abs(n);
            double ans = 1;
            for (int i = 0; i < ln; i++)
                ans *= x;
            return n > 0 ? ans : 1.0 / ans;
        }

        public double myPow2(double x, int n) {
            long ln = n;
            ln = ln < 0 ? -1 * ln : ln;
            double ans = 1.0;
            while (ln > 0) {
                if (ln % 2 == 0) {
                    x *= x;
                    ln /= 2;
                } else {
                    ans *= x;
                    ln--;
                }
            }
            return n > 0 ? ans : 1.0 / ans;
        }
    }


    public static void main(String args[]) {
        Solution sol = new Solution();
        double x = 2;
        int n = 10;
        System.out.println(sol.myPow2(x, n));
    }
}
