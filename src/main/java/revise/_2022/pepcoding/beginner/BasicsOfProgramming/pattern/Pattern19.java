// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pattern19.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.pattern;

import java.io.PrintStream;
import java.util.Scanner;

public class Pattern19
{

    public Pattern19()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n; j++)
            {
                if(i == 1)
                {
                    if(j <= n / 2 + 1 || j == n)
                        System.out.print("*\t");
                    else
                        System.out.print("\t");
                    continue;
                }
                if(i <= n / 2)
                {
                    if(j == n / 2 + 1 || j == n)
                        System.out.print("*\t");
                    else
                        System.out.print("\t");
                    continue;
                }
                if(i == n / 2 + 1)
                {
                    System.out.print("*\t");
                    continue;
                }
                if(i < n)
                {
                    if(j == 1 || j == n / 2 + 1)
                        System.out.print("*\t");
                    else
                        System.out.print("\t");
                    continue;
                }
                if(j == 1 || j >= n / 2 + 1)
                    System.out.print("*\t");
                else
                    System.out.print("\t");
            }

            System.out.println();
        }

    }
}
