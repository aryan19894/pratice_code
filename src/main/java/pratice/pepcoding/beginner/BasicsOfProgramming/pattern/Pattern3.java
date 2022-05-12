// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pattern3.java

package pratice.pepcoding.beginner.BasicsOfProgramming.pattern;

import java.io.PrintStream;
import java.util.Scanner;

public class Pattern3
{

    public Pattern3()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        for(int i = 1; i <= n; i++)
        {
            for(int j = 0; j < n - i; j++)
                System.out.print("\t");

            for(int j = 0; j < i; j++)
                System.out.print("*\t");

            System.out.println();
        }

    }
}
