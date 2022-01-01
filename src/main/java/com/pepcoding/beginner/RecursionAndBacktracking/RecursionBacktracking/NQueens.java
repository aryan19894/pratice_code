// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NQueens.java

package com.pepcoding.beginner.RecursionAndBacktracking.RecursionBacktracking;

import java.io.PrintStream;
import java.util.Scanner;

public class NQueens
{

    public NQueens()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[][] = new int[n][n];
        printNQueens(arr, "", 0);
    }

    public static void printNQueens(int chess[][], String qsf, int row)
    {
        if(row == chess.length)
        {
            System.out.println((new StringBuilder()).append(qsf).append(".").toString());
            return;
        }
        for(int col = 0; col < chess.length; col++)
            if(IsQueenAtSafePlace(chess, row, col))
            {
                chess[row][col] = 1;
                printNQueens(chess, (new StringBuilder()).append(qsf).append(row).append("-").append(col).append(", ").toString(), row + 1);
                chess[row][col] = 0;
            }

    }

    private static boolean IsQueenAtSafePlace(int chess[][], int row, int col)
    {
        int i = row - 1;
        int j = col;
        for(; i >= 0; i--)
            if(chess[i][j] == 1)
                return false;

        i = row - 1;
        for(j = col - 1; i >= 0 && j >= 0; j--)
        {
            if(chess[i][j] == 1)
                return false;
            i--;
        }

        i = row - 1;
        for(j = col + 1; i >= 0 && j < chess.length; j++)
        {
            if(chess[i][j] == 1)
                return false;
            i--;
        }

        return true;
    }
}
