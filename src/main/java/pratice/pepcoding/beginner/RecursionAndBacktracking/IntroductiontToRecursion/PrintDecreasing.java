// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintDecreasing.java

package pratice.pepcoding.beginner.RecursionAndBacktracking.IntroductiontToRecursion;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintDecreasing
{

    public PrintDecreasing()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        printDecreasing(n);
    }

    public static void printDecreasing(int n)
    {
        if(n == 0)
        {
            return;
        } else
        {
            System.out.println(n);
            printDecreasing(n - 1);
            return;
        }
    }
}
