// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GcdAndLcm.java

package com.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class GcdAndLcm
{

    public GcdAndLcm()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int x = a * b;
        int r;
        for(; a % b > 0; b = r)
        {
            r = a % b;
            a = b;
        }

        int gcd = b;
        int lcm = x / gcd;
        System.out.println(gcd);
        System.out.println(lcm);
    }
}
