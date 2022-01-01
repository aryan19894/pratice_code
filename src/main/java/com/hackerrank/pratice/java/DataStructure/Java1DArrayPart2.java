// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Java1DArrayPart2.java

package com.hackerrank.pratice.java.DataStructure;

import java.io.PrintStream;
import java.util.Scanner;

public class Java1DArrayPart2
{

    public Java1DArrayPart2()
    {
    }

    public static boolean canWin(int leap, int game[])
    {
        if(game == null)
            return false;
        else
            return isSolvable(leap, game, 0);
    }

    private static boolean isSolvable(int m, int arr[], int i)
    {
        if(i < 0 || arr[i] == 1)
            return false;
        if(i == arr.length - 1 || i + m > arr.length - 1)
        {
            return true;
        } else
        {
            arr[i] = 1;
            return isSolvable(m, arr, i + 1) || isSolvable(m, arr, i - 1) || isSolvable(m, arr, i + m);
        }
    }

    public static void main(String args[])
    {
        Scanner scan = new Scanner(System.in);
        for(int q = scan.nextInt(); q-- > 0;)
        {
            int n = scan.nextInt();
            int leap = scan.nextInt();
            int game[] = new int[n];
            for(int i = 0; i < n; i++)
                game[i] = scan.nextInt();

            System.out.println(canWin(leap, game) ? "YES" : "NO");
        }

        scan.close();
    }
}
