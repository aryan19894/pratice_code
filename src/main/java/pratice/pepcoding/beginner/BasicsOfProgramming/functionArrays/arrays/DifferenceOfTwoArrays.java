// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DifferenceOfTwoArrays.java

package pratice.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class DifferenceOfTwoArrays
{

    public DifferenceOfTwoArrays()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n1 = scn.nextInt();
        int a1[] = new int[n1];
        for(int i = 0; i < n1; i++)
            a1[i] = scn.nextInt();

        int n2 = scn.nextInt();
        int a2[] = new int[n2];
        for(int i = 0; i < n2; i++)
            a2[i] = scn.nextInt();

        int diff[] = new int[n1 <= n2 ? n2 : n1];
        int c = 0;
        int i = a1.length - 1;
        int j = a2.length - 1;
        for(int k = diff.length - 1; k >= 0; k--)
        {
            int d = c;
            if(i >= 0)
                d -= a1[i];
            if(j >= 0)
                d += a2[j];
            if(d < 0)
            {
                d += 10;
                c = -1;
            } else
            {
                c = 0;
            }
            diff[k] = d;
            i--;
            j--;
        }

        int id;
        for(id = 0; id < diff.length && diff[id] == 0; id++);
        for(; id < diff.length; id++)
            System.out.println(diff[id]);

    }
}
