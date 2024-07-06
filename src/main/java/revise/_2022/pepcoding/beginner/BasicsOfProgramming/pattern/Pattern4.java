// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pattern4.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.pattern;

import java.io.PrintStream;
import java.util.Scanner;

public class Pattern4
{

    public Pattern4()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sp = 0;
        int st = n;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= sp; j++)
                System.out.print("\t");

            for(int j = 1; j <= st; j++)
                System.out.print("*\t");

            sp++;
            st--;
            System.out.println();
        }

    }
}
