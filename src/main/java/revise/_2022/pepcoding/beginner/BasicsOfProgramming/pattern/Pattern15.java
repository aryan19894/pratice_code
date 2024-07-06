// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pattern15.java

package revise._2022.pepcoding.beginner.BasicsOfProgramming.pattern;

import java.io.PrintStream;
import java.util.Scanner;

public class Pattern15
{

    public Pattern15()
    {
    }

    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int val = 1;
        int sp = n / 2;
        int st = 1;
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= sp; j++)
                System.out.print("\t");

            int cval = val;
            for(int j = 1; j <= st; j++)
            {
                System.out.print((new StringBuilder()).append(cval).append("\t").toString());
                if(j <= st / 2)
                    cval++;
                else
                    cval--;
            }

            if(i < n / 2 + 1)
            {
                sp--;
                st += 2;
                val++;
            } else
            {
                sp++;
                st -= 2;
                val--;
            }
            System.out.println();
        }

    }
}
