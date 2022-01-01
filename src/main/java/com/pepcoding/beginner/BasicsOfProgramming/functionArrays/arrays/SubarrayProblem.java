// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SubarrayProblem.java

package com.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class SubarrayProblem
{

    public SubarrayProblem()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        getSubArray(n, arr);
    }

    private static void getSubArray(int n, int arr[])
    {
        for(int i = 0; i < n; i++)
        {
            for(int j = i; j < n; j++)
            {
                for(int k = i; k <= j; k++)
                    System.out.print((new StringBuilder()).append(arr[k]).append("\t").toString());

                System.out.println();
            }

        }

    }
}
