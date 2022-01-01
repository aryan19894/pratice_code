// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SubsetsOfArray.java

package revise.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class SubsetsOfArray
{

    public SubsetsOfArray()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = scn.nextInt();

        int c = (int)Math.pow(2D, n);
        for(int i = 0; i < c; i++)
        {
            int temp = i;
            String set = "";
            for(int j = n - 1; j >= 0; j--)
            {
                int r = temp % 2;
                temp /= 2;
                if(r == 0)
                    set = (new StringBuilder()).append("-\t").append(set).toString();
                else
                    set = (new StringBuilder()).append(a[j]).append("\t").append(set).toString();
            }

            System.out.println(set);
        }

    }
}
