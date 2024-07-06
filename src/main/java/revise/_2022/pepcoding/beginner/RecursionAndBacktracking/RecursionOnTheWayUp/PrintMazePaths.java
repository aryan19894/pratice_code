// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintMazePaths.java

package revise._2022.pepcoding.beginner.RecursionAndBacktracking.RecursionOnTheWayUp;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintMazePaths
{

    public PrintMazePaths()
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
        if(sc < dc)
            printMazePaths(sr, sc + 1, dr, dc, (new StringBuilder()).append(psf).append("h").toString());
        if(sr < dr)
            printMazePaths(sr + 1, sc, dr, dc, (new StringBuilder()).append(psf).append("v").toString());
    }
}
