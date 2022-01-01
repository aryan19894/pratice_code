// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SumOfTwoArrays.java

package com.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class SumOfTwoArrays
{

    public SumOfTwoArrays()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int arr1[] = new int[n1];
        for(int i = 0; i < n1; i++)
            arr1[i] = scn.nextInt();

        int n2 = scn.nextInt();
        int arr2[] = new int[n2];
        for(int i = 0; i < n2; i++)
            arr2[i] = scn.nextInt();

        int arr3[] = new int[n1 <= n2 ? n2 : n1];
        int c = 0;
        int i = arr1.length - 1;
        int j = arr2.length - 1;
        for(int k = arr3.length - 1; k >= 0; k--)
        {
            int d = c;
            if(i >= 0)
                d += arr1[i];
            if(j >= 0)
                d += arr2[j];
            c = d / 10;
            d %= 10;
            arr3[k] = d;
            i--;
            j--;
        }

        if(c != 0)
            System.out.println(c);
        int ai[] = arr3;
        int l = ai.length;
        for(int i1 = 0; i1 < l; i1++)
        {
            int val = ai[i1];
            System.out.println(val);
        }

    }
}
