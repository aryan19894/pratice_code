// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   PrintZigzag.java

package revise.pepcoding.beginner.RecursionAndBacktracking.IntroductiontToRecursion;

import java.io.PrintStream;
import java.util.Scanner;

public class PrintZigzag
{

    public PrintZigzag()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        pzz(n);
    }

    public static void pzz(int n)
    {
        if(n == 0)
        {
            return;
        } else
        {
            System.out.print((new StringBuilder()).append(n).append(" ").toString());
            pzz(n - 1);
            System.out.print((new StringBuilder()).append(n).append(" ").toString());
            pzz(n - 1);
            System.out.print((new StringBuilder()).append(n).append(" ").toString());
            return;
        }
    }
}
