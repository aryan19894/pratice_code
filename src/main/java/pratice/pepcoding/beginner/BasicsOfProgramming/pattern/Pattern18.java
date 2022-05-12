// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pattern18.java

package pratice.pepcoding.beginner.BasicsOfProgramming.pattern;

import java.io.PrintStream;
import java.util.Scanner;

public class Pattern18
{

    public Pattern18()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int sp = 0;
        int st = n;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= sp; j++)
                System.out.print("\t");

            for(int j = 1; j <= st; j++)
                if(i > 1 && i <= n / 2 && j > 1 && j < st)
                    System.out.print("\t");
                else
                    System.out.print("*\t");

            if(i <= n / 2)
            {
                sp++;
                st -= 2;
            } else
            {
                sp--;
                st += 2;
            }
            System.out.println();
        }

    }
}
