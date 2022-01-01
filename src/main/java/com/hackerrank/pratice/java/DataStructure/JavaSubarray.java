// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JavaSubarray.java

package com.hackerrank.pratice.java.DataStructure;

import java.io.PrintStream;
import java.util.Scanner;

public class JavaSubarray
{

    public JavaSubarray()
    {
    }

    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int count = 0;
        for(int i = 0; i < n; i++)
        {
            int sum = 0;
            for(int j = i; j < n; j++)
            {
                sum += a[j];
                if(sum < 0)
                    count++;
            }

        }

        System.out.println(count);
    }
}
