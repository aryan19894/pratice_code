// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AnyBaseSubtraction.java

package com.pepcoding.beginner.BasicsOfProgramming.functionArrays.NumberSystem;

import java.io.PrintStream;
import java.util.Scanner;

public class AnyBaseSubtraction
{

    public AnyBaseSubtraction()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int b = scn.nextInt();
        int n1 = scn.nextInt();
        int n2 = scn.nextInt();
        int d = getDiff(b, n1, n2);
        System.out.println(d);
    }

    public static int getDiff(int b, int n1, int n2)
    {
        int ans = 0;
        int p = 0;
        int carry = 0;
        for(; n2 > 0 || n1 > 0; n2 /= 10)
        {
            int r1 = n2 % 10;
            int r2 = n1 % 10;
            if(carry != 0)
                r1--;
            if(r1 < r2)
                carry = b;
            else
                carry = 0;
            int diff = (r1 + carry) - r2;
            ans = (int)((double)ans + Math.pow(10D, p++) * (double)diff);
            n1 /= 10;
        }

        return ans;
    }
}
