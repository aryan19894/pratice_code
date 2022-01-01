// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   D2ArraysDemo.java

package com.pepcoding.beginner.BasicsOfProgramming.d2Arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class D2ArraysDemo
{

    public D2ArraysDemo()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int arr[][] = new int[n][m];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
                arr[i][j] = scn.nextInt();

        }

        display(n, m, arr);
    }

    private static void display(int n, int m, int arr[][])
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
                System.out.print((new StringBuilder()).append(arr[i][j]).append(" ").toString());

            System.out.println();
        }

    }
}
