// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pattern17.java

package com.pepcoding.beginner.BasicsOfProgramming.pattern;

import java.io.PrintStream;
import java.util.Scanner;

public class Pattern17
{

    public Pattern17()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sp = n / 2;
        int st = 1;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= sp; j++)
                if(i == n / 2 + 1)
                    System.out.print("*\t");
                else
                    System.out.print("\t");

            for(int j = 1; j <= st; j++)
                System.out.print("*\t");

            if(i <= n / 2)
                st++;
            else
                st--;
            System.out.println();
        }

    }
}
