// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   SubsetsOfArray2.java

package pratice.pepcoding.beginner.BasicsOfProgramming.functionArrays.arrays;

import java.io.PrintStream;
import java.util.Scanner;

public class SubsetsOfArray2
{

    public SubsetsOfArray2()
    {
    }

    public static void main(String args[])
        throws Exception
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        getSubset(n, arr);
    }

    private static void getSubset(int n, int arr[])
    {
        int limit = (int)Math.pow(2D, n);
        for(int i = 0; i < limit; i++)
        {
            String set = "";
            int temp = i;
            for(int j = n - 1; j >= 0; j--)
            {
                int r = temp % 2;
                temp /= 2;
                if(r == 0)
                    set = (new StringBuilder()).append("-\t").append(set).toString();
                else
                    set = (new StringBuilder()).append(arr[j]).append("\t").append(set).toString();
            }

            System.out.println(set);
        }

    }
}
