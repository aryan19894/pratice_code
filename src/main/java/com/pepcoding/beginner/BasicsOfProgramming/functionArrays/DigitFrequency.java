// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DigitFrequency.java

package com.pepcoding.beginner.BasicsOfProgramming.functionArrays;

import java.io.PrintStream;
import java.util.Scanner;

public class DigitFrequency
{

    public DigitFrequency()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int d = scn.nextInt();
        int f = getDigitFrequency(n, d);
        System.out.println(f);
    }

    public static int getDigitFrequency(int n, int d)
    {
        int c = 0;
        for(; n > 0; n /= 10)
        {
            int r = n % 10;
            if(r == d)
                c++;
        }

        return c;
    }
}
