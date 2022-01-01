// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pattern10.java

package revise.pepcoding.beginner.BasicsOfProgramming.pattern;

import java.io.PrintStream;
import java.util.Scanner;

public class Pattern10
{

    public Pattern10()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int os = n / 2;
        int is = -1;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= os; j++)
                System.out.print("\t");

            System.out.print("*\t");
            for(int j = 1; j <= is; j++)
                System.out.print("\t");

            if(i > 1 && i < n)
                System.out.print("*\t");
            if(i < n / 2 + 1)
            {
                os--;
                is += 2;
            } else
            {
                os++;
                is -= 2;
            }
            System.out.println();
        }

    }
}
