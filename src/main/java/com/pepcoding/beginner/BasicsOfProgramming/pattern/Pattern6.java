// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pattern6.java

package com.pepcoding.beginner.BasicsOfProgramming.pattern;

import java.io.PrintStream;
import java.util.Scanner;

public class Pattern6
{

    public Pattern6()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int st = n / 2 + 1;
        int sp = 1;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= st; j++)
                System.out.print("*\t");

            for(int j = 1; j <= sp; j++)
                System.out.print("\t");

            for(int j = 1; j <= st; j++)
                System.out.print("*\t");

            if(i <= n / 2)
            {
                st--;
                sp += 2;
            } else
            {
                st++;
                sp -= 2;
            }
            System.out.println();
        }

    }
}
