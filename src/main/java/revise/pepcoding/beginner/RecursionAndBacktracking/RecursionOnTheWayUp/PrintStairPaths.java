// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintStairPaths.java

package revise.pepcoding.beginner.RecursionAndBacktracking.RecursionOnTheWayUp;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintStairPaths
{

    public PrintStairPaths()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printStairPaths(n, "");
    }

    public static void printStairPaths(int n, String path)
    {
        if(n == 0)
        {
            System.out.println(path);
            return;
        }
        if(n < 0)
        {
            return;
        } else
        {
            printStairPaths(n - 1, (new StringBuilder()).append(path).append("1").toString());
            printStairPaths(n - 2, (new StringBuilder()).append(path).append("2").toString());
            printStairPaths(n - 3, (new StringBuilder()).append(path).append("3").toString());
            return;
        }
    }
}
