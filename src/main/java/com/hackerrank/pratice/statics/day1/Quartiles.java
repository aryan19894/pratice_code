// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Quartiles.java

package com.hackerrank.pratice.statics.day1;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class Quartiles
{

    public Quartiles()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = in.nextInt();

        Arrays.sort(a);
        calculate(a, 0, n / 2 - 1);
        calculate(a, 0, n - 1);
        calculate(a, (n + 1) / 2, n - 1);
    }

    private static void calculate(int a[], int l, int r)
    {
        if(isEven(r - l))
        {
            System.out.println(a[(r + l) / 2]);
        } else
        {
            int value1 = a[(r + l) / 2];
            int value2 = a[(r + l) / 2 + 1];
            System.out.println(Math.round((value1 + value2) / 2));
        }
    }

    private static boolean isEven(int n)
    {
        return n % 2 == 0;
    }
}
