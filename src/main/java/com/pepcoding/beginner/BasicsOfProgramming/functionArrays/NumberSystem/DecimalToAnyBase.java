// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DecimalToAnyBase.java

package com.pepcoding.beginner.BasicsOfProgramming.functionArrays.NumberSystem;

import java.io.PrintStream;
import java.util.Scanner;

public class DecimalToAnyBase
{

    public DecimalToAnyBase()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int b = scn.nextInt();
        int dn = getValueInBase(n, b);
        System.out.println(dn);
    }

    public static int getValueInBase(int n, int b)
    {
        int ans = 0;
        int p = 0;
        for(; n >= 1; n /= b)
        {
            int r = n % b;
            ans = (int)((double)ans + Math.pow(10D, p++) * (double)r);
        }

        return ans;
    }
}
