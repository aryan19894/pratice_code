// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TheStateOfWakanda1.java

package com.pepcoding.beginner.BasicsOfProgramming.d2Arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class TheStateOfWakanda1
{

    public TheStateOfWakanda1()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int m1 = scn.nextInt();
        int a[][] = new int[n1][m1];
        for(int i = 0; i < n1; i++)
        {
            for(int j = 0; j < m1; j++)
                a[i][j] = scn.nextInt();

        }

        getWakandaPath(n1, m1, a);
    }

    private static void getWakandaPath(int n1, int m1, int a[][])
    {
        for(int i = 0; i < m1; i++)
        {
            if(i % 2 == 0)
            {
                for(int j = 0; j < n1; j++)
                    System.out.println(a[j][i]);

                continue;
            }
            for(int j = n1 - 1; j >= 0; j--)
                System.out.println(a[j][i]);

        }

    }

    private static void display(int arr[][])
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[i].length; j++)
                System.out.print((new StringBuilder()).append(arr[i][j]).append(" ").toString());

            System.out.println();
        }

    }
}
