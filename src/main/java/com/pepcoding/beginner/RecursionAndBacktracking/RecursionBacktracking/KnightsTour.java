// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   KnightsTour.java

package com.pepcoding.beginner.RecursionAndBacktracking.RecursionBacktracking;

import java.io.PrintStream;
import java.util.Scanner;

public class KnightsTour
{

    public KnightsTour()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        int arr[][] = new int[n][n];
        printKnightsTour(arr, r, c, 1);
    }

    public static void printKnightsTour(int chess[][], int r, int c, int move)
    {
        if(r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0)
            return;
        if(move == chess.length * chess.length)
        {
            chess[r][c] = move;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        } else
        {
            chess[r][c] = move;
            printKnightsTour(chess, r - 2, c + 1, move + 1);
            printKnightsTour(chess, r - 1, c + 2, move + 1);
            printKnightsTour(chess, r + 1, c + 2, move + 1);
            printKnightsTour(chess, r + 2, c + 1, move + 1);
            printKnightsTour(chess, r + 2, c - 1, move + 1);
            printKnightsTour(chess, r + 1, c - 2, move + 1);
            printKnightsTour(chess, r - 1, c - 2, move + 1);
            printKnightsTour(chess, r - 2, c - 1, move + 1);
            chess[r][c] = 0;
            return;
        }
    }

    public static void displayBoard(int chess[][])
    {
        for(int i = 0; i < chess.length; i++)
        {
            for(int j = 0; j < chess[0].length; j++)
                System.out.print((new StringBuilder()).append(chess[i][j]).append(" ").toString());

            System.out.println();
        }

        System.out.println();
    }
}
