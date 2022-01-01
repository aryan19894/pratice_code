// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PythagoreanTriplet.java

package com.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class PythagoreanTriplet
{

    public PythagoreanTriplet()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int c = in.nextInt();
        int flag = 0;
        if(Math.sqrt((a - b) * (a + b)) == (double)c)
            flag = 1;
        if(Math.sqrt((a - c) * (a + c)) == (double)b)
            flag = 1;
        if(Math.sqrt((c - b) * (c + b)) == (double)a)
            flag = 1;
        if(flag == 1)
            System.out.println(true);
        else
            System.out.println(false);
    }
}
