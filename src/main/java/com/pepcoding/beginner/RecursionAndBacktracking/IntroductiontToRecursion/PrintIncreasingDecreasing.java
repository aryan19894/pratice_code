// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintIncreasingDecreasing.java

package com.pepcoding.beginner.RecursionAndBacktracking.IntroductiontToRecursion;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintIncreasingDecreasing
{

    public PrintIncreasingDecreasing()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pdi(n);
    }

    public static void pdi(int n)
    {
        if(n == 0)
        {
            return;
        } else
        {
            System.out.println(n);
            pdi(n - 1);
            System.out.println(n);
            return;
        }
    }
}
