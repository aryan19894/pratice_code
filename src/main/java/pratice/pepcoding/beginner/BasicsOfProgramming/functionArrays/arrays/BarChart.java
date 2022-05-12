// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BarChart.java

package pratice.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class BarChart
{

    public BarChart()
    {
    }

    public static void main(String args[])
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int max = arr[0];
        for(int i = 1; i < n; i++)
            if(arr[i] > max)
                max = arr[i];

        for(int f = max; f >= 1; f--)
        {
            for(int i = 0; i < n; i++)
                if(arr[i] >= f)
                    System.out.print("*\t");
                else
                    System.out.print("\t");

            System.out.println();
        }

    }
}
