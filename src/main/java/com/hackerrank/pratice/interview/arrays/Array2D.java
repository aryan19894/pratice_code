// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Array2D.java

package com.hackerrank.pratice.interview.arrays;

import com.common.Out;

import java.util.Scanner;

public class Array2D
{

    public Array2D()
    {
    }

    static int hourglassSum(int arr[][])
    {
        int finalSum = 0x80000000;
        int colTrack = 1;
        for(int r1 = 0; r1 < arr.length - 2; r1++)
        {
            for(int c1 = 0; c1 < arr[r1].length - 2; c1++)
            {
                int sum = 0;
                colTrack = 1;
                for(int r2 = r1; r2 <= r1 + 2; r2++)
                {
                    if(colTrack == 2)
                    {
                        for(int c2 = c1 + 1; c2 <= c1 + 1; c2++)
                            sum += arr[r2][c2];

                    } else
                    {
                        for(int c2 = c1; c2 <= c1 + 2; c2++)
                            sum += arr[r2][c2];

                    }
                    colTrack++;
                }

                if(finalSum < sum)
                    finalSum = sum;
            }

        }

        return finalSum;
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int a[][] = new int[6][6];
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 6; j++)
                a[i][j] = in.nextInt();

        }

        Out.print(a);
        int ans = hourglassSum(a);
        System.out.println(ans);
    }
}
