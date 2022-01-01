// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Java2DArray.java

package com.hackerrank.pratice.java.DataStructure;

import java.io.PrintStream;
import java.util.Scanner;

public class Java2DArray
{

    public Java2DArray()
    {
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int row = 0; row < 6; row++)
        {
            for(int col = 0; col < 6; col++)
                arr[row][col] = scan.nextInt();

        }

        scan.close();
        System.out.println(maxHourglass(arr));
    }

    public static int maxHourglass(int arr[][])
    {
        int max = 0x80000000;
        for(int row = 0; row < 4; row++)
        {
            for(int col = 0; col < 4; col++)
            {
                int sum = findSum(arr, row, col);
                max = Math.max(max, sum);
            }

        }

        return max;
    }

    private static int findSum(int arr[][], int r, int c)
    {
        int sum = arr[r + 0][c + 0] + arr[r + 0][c + 1] + arr[r + 0][c + 2] + arr[r + 1][c + 1] + arr[r + 2][c + 0] + arr[r + 2][c + 1] + arr[r + 2][c + 2];
        return sum;
    }
}
