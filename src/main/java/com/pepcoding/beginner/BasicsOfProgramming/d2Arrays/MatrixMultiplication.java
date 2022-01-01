// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MatrixMultiplication.java

package com.pepcoding.beginner.BasicsOfProgramming.d2Arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class MatrixMultiplication
{

    public MatrixMultiplication()
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

        int n2 = scn.nextInt();
        int m2 = scn.nextInt();
        int b[][] = new int[n2][m2];
        for(int i = 0; i < n2; i++)
        {
            for(int j = 0; j < m2; j++)
                b[i][j] = scn.nextInt();

        }

        display(a);
        display(b);
        product(n1, m1, a, n2, m2, b);
    }

    private static int[][] product(int n1, int m1, int a[][], int n2, int m2, int b[][])
    {
        int c[][] = new int[n1][m2];
        if(m1 == n2)
        {
            for(int i = 0; i < n1; i++)
            {
                for(int j = 0; j < m2; j++)
                {
                    for(int k = 0; k < n2; k++)
                        c[i][j] += a[i][k] * b[k][j];

                }

            }

            display(c);
        } else
        {
            System.out.println("Invalid input");
        }
        return c;
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
