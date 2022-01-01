// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Day20_Sorting.java

package com.hackerrank.pratice.Day30OfCode;

import java.io.PrintStream;
import java.util.Scanner;

public class Day20_Sorting
{

    public Day20_Sorting()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        for(int a_i = 0; a_i < n; a_i++)
            a[a_i] = in.nextInt();

        int numberOfSwaps = 0;
        int i = 0;
        do
        {
            if(i >= n - 1)
                break;
            for(int j = 0; j < n - i - 1; j++)
                if(a[j] > a[j + 1])
                {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                    numberOfSwaps++;
                }

            if(numberOfSwaps == 0)
                break;
            i++;
        } while(true);
        System.out.println((new StringBuilder()).append("Array is sorted in ").append(numberOfSwaps).append(" swaps.").toString());
        System.out.println((new StringBuilder()).append("First Element: ").append(a[0]).toString());
        System.out.println((new StringBuilder()).append("Last Element: ").append(a[a.length - 1]).toString());
    }
}
