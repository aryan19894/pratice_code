// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AnyBaseAddition.java

package com.pepcoding.beginner.BasicsOfProgramming.functionArrays.NumberSystem;

import java.io.PrintStream;
import java.util.Scanner;

public class AnyBaseAddition
{

    public AnyBaseAddition()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int d = getSum(b, n1, n2);
        System.out.println(d);
    }

    public static int getSum(int b, int n1, int n2)
    {
        int ans = 0;
        int p = 0;
        int carry = 0;
        for(; n1 > 0 || n2 > 0; n2 /= 10)
        {
            int r1 = n1 % 10;
            int r2 = n2 % 10;
            int sum = carry + r1 + r2;
            carry = sum / b;
            int digit = sum % b;
            ans = (int)((double)ans + Math.pow(10D, p++) * (double)digit);
            n1 /= 10;
        }

        if(carry != 0)
            ans = (int)((double)ans + Math.pow(10D, p++) * (double)carry);
        return ans;
    }
}
