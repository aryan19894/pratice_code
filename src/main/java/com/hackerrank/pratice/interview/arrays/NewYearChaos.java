// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NewYearChaos.java

package com.hackerrank.pratice.interview.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class NewYearChaos
{

    public NewYearChaos()
    {
    }

    static void minimumBribes(int q[])
    {
        int c = 0;
        int min = q.length;
        for(int i = q.length - 1; i >= 0; i--)
        {
            if(q[i] - i > 3)
            {
                System.out.println("Too chaotic");
                c = -1;
                break;
            }
            if(q[i] > i + 1)
            {
                c += q[i] - (i + 1);
                continue;
            }
            if(min > q[i])
            {
                min = q[i];
                continue;
            }
            if(q[i] != min)
                c++;
        }

        if(c != -1)
            System.out.println(c);
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++)
        {
            int n = in.nextInt();
            int a[] = new int[n];
            for(int j = 0; j < n; j++)
                a[j] = in.nextInt();

            minimumBribes(a);
        }

    }
}
