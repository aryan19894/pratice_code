// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pattern13.java

package revise.pepcoding.beginner.BasicsOfProgramming.pattern;

import java.io.PrintStream;
import java.util.Scanner;

public class Pattern13
{

    public Pattern13()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0; i < n; i++)
        {
            int icj = 1;
            for(int j = 0; j <= i; j++)
            {
                System.out.print((new StringBuilder()).append(icj).append("\t").toString());
                icj = (icj * (i - j)) / (j + 1);
            }

            System.out.println();
        }

    }
}
