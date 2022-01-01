// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   NQueens.java

package revise.pepcoding.beginner.RecursionAndBacktracking.RecursionBacktracking;

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

    public static void printNQueens(int chess[][], String qsf, int r)
    {
        if(r == chess.length)
        {
            System.out.println((new StringBuilder()).append(qsf).append(".").toString());
            return;
        }
        for(int c = 0; c < chess.length; c++)
            if(IsQueenAtSafePlace(chess, r, c))
            {
                chess[r][c] = 1;
                printNQueens(chess, (new StringBuilder()).append(qsf).append(r).append("-").append(c).append(", ").toString(), r + 1);
                chess[r][c] = 0;
            }

    }

    private static boolean IsQueenAtSafePlace(int chess[][], int r, int c)
    {
        int i = r - 1;
        int j = c;
        for(; i >= 0; i--)
            if(chess[i][j] == 1)
                return false;

        i = r - 1;
        for(j = c - 1; i >= 0 && j >= 0; j--)
        {
            if(chess[i][j] == 1)
                return false;
            i--;
        }

        i = r - 1;
        for(j = c + 1; i >= 0 && j < chess.length; j++)
        {
            if(chess[i][j] == 1)
                return false;
            i--;
        }

        return true;
    }
}
