// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pattern16.java

package pratice.pepcoding.beginner.BasicsOfProgramming.pattern;

import java.io.PrintStream;
import java.util.Scanner;

public class Pattern16
{

    public Pattern16()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sp = 2 * n - 3;
        int st = 1;
        for(int i = 1; i <= n; i++)
        {
            int val = 1;
            for(int j = 1; j <= st; j++)
                System.out.print((new StringBuilder()).append(val++).append("\t").toString());

            for(int j = 1; j <= sp; j++)
                System.out.print("\t");

            if(i == n)
            {
                val--;
                st--;
            }
            for(int j = 1; j <= st; j++)
                System.out.print((new StringBuilder()).append(--val).append("\t").toString());

            st++;
            sp -= 2;
            System.out.println();
        }

    }
}
