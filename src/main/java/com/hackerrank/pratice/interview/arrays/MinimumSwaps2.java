// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MinimumSwaps2.java

package com.hackerrank.pratice.interview.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class MinimumSwaps2
{

    public MinimumSwaps2()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        int min = 0;
        for(int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
            if(i == 0)
            {
                min = a[i];
                continue;
            }
            if(min > a[i - 1])
                min = a[i - 1];
        }

        if(min != 1)
        {
            for(int i = 0; i < n; i++)
                a[i] = a[i] - (min - 1);

        }
        int count = 0;
        int temp = 0;
        for(int i = 0; i < n;)
            if(a[i] != i + 1)
            {
                temp = a[i];
                a[i] = a[temp - 1];
                a[temp - 1] = temp;
                count++;
            } else
            {
                i++;
            }

        System.out.println(count);
    }
}
