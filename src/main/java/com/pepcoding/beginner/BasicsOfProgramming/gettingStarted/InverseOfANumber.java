// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   InverseOfANumber.java

package com.pepcoding.beginner.BasicsOfProgramming.gettingStarted;

import java.io.PrintStream;
import java.util.Scanner;

public class InverseOfANumber
{

    public InverseOfANumber()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;
        for(int i = 1; n > 0; i++)
        {
            int r = n % 10;
            ans += i * (int)Math.pow(10D, r - 1);
            n /= 10;
        }

        System.out.println(ans);
    }
}
