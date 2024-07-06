// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintMazePathsWithJumps.java

package revise._2022.pepcoding.beginner.RecursionAndBacktracking.RecursionOnTheWayUp;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintMazePathsWithJumps
{

    public PrintMazePathsWithJumps()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        printMazePaths(1, 1, n, m, "");
    }

    public static void printMazePaths(int sr, int sc, int dr, int dc, String psf)
    {
        if(sr == dr && sc == dc)
        {
            System.out.println(psf);
            return;
        }
        for(int i = 1; i <= dc - sc; i++)
            printMazePaths(sr, sc + i, dr, dc, (new StringBuilder()).append(psf).append("h").append(i).toString());

        for(int i = 1; i <= dr - sr; i++)
            printMazePaths(sr + i, sc, dr, dc, (new StringBuilder()).append(psf).append("v").append(i).toString());

        for(int i = 1; i <= dc - sc && i <= dr - sr; i++)
            printMazePaths(sr + i, sc + i, dr, dc, (new StringBuilder()).append(psf).append("d").append(i).toString());

    }
}
