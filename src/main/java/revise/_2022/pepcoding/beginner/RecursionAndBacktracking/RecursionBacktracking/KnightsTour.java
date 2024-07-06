// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   KnightsTour.java

package revise._2022.pepcoding.beginner.RecursionAndBacktracking.RecursionBacktracking;

import java.io.PrintStream;
import java.util.Scanner;

public class KnightsTour
{

    public KnightsTour()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int r = scn.nextInt();
        int c = scn.nextInt();
        int chess[][] = new int[n][n];
        printKnightsTour(chess, r, c, 1);
    }

    public static void printKnightsTour(int chess[][], int r, int c, int moves)
    {
        if(r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0)
            return;
        if(moves == chess.length * chess.length)
        {
            chess[r][c] = moves;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        } else
        {
            chess[r][c] = moves;
            printKnightsTour(chess, r - 2, c + 1, moves + 1);
            printKnightsTour(chess, r - 1, c + 2, moves + 1);
            printKnightsTour(chess, r + 1, c + 2, moves + 1);
            printKnightsTour(chess, r + 2, c + 1, moves + 1);
            printKnightsTour(chess, r + 2, c - 1, moves + 1);
            printKnightsTour(chess, r + 1, c - 2, moves + 1);
            printKnightsTour(chess, r - 1, c - 2, moves + 1);
            printKnightsTour(chess, r - 2, c - 1, moves + 1);
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
