// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RotateBy90Degree.java

package com.pepcoding.beginner.BasicsOfProgramming.d2Arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class RotateBy90Degree
{

    public RotateBy90Degree()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[][] = new int[n][n];
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
                a[i][j] = scn.nextInt();

        }

        rotateby90(a);
    }

    private static void rotateby90(int a[][])
    {
        for(int i = 0; i < a.length; i++)
        {
            for(int j = i; j < a[0].length; j++)
            {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }

        }

        for(int i = 0; i < a.length; i++)
        {
            int li = 0;
            for(int ri = a[i].length - 1; li < ri; ri--)
            {
                int temp = a[i][li];
                a[i][li] = a[i][ri];
                a[i][ri] = temp;
                li++;
            }

        }

        display(a);
    }

    public static void display(int arr[][])
    {
        for(int i = 0; i < arr.length; i++)
        {
            for(int j = 0; j < arr[0].length; j++)
                System.out.print((new StringBuilder()).append(arr[i][j]).append(" ").toString());

            System.out.println();
        }

    }
}
