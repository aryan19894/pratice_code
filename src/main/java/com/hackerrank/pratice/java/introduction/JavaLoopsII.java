// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaLoopsII.java

package com.hackerrank.pratice.java.introduction;

import java.io.PrintStream;
import java.util.Scanner;

public class JavaLoopsII
{

    public JavaLoopsII()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++)
        {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int sum = (int)((double)a + Math.pow(2D, 0.0D) * (double)b);
            for(int j = 1; j <= n; j++)
            {
                System.out.print((new StringBuilder()).append(sum).append(" ").toString());
                sum = (int)((double)sum + Math.pow(2D, j) * (double)b);
            }

            System.out.println();
        }

        in.close();
    }
}
