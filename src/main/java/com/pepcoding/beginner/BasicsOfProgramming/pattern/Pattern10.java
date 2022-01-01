// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pattern10.java

package com.pepcoding.beginner.BasicsOfProgramming.pattern;

import java.io.PrintStream;
import java.util.Scanner;

public class Pattern10
{

    public Pattern10()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int osp = n / 2;
        int isp = -1;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= osp; j++)
                System.out.print("\t");

            System.out.print("*\t");
            for(int j = 1; j <= isp; j++)
                System.out.print("\t");

            if(i > 1 && i < n)
                System.out.print("*\t");
            if(i <= n / 2)
            {
                osp--;
                isp += 2;
            } else
            {
                osp++;
                isp -= 2;
            }
            System.out.println();
        }

    }
}
